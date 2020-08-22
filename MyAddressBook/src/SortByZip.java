import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SortByZip extends JFrame {

	private JPanel contentPane;
	private JTextField bookid_textField;
	private JTextArea display_textArea;
	
	MainBook booky = new MainBook();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortByZip frame = new SortByZip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortByZip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				MainBook home = new MainBook();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(455, 387, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(142, 295, 92, 23);
		contentPane.add(lblNewLabel);
		
		bookid_textField = new JTextField();
		bookid_textField.setBounds(300, 295, 86, 20);
		contentPane.add(bookid_textField);
		bookid_textField.setColumns(10);
		
		display_textArea = new JTextArea();
		display_textArea.setBounds(117, 71, 318, 213);
		contentPane.add(display_textArea);
		
		JButton btnNewButton_1 = new JButton("SORT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booky.fileReader();
				
				String select = bookid_textField.getText();
				try {
					int sel = Integer.parseInt(select); 
					String keys = booky.addressbook[sel];
					List<MainBook> arraylist = booky.map.get(keys);
					Collections.sort(arraylist, MainBook.sortbyzip);
					booky.fileWriter();
					
					for (MainBook str : arraylist) {
						display_textArea.setCaret((Caret) str);
					}
					
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "It should an integer");
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(227, 329, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
