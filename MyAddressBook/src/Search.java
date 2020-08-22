import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField bookid_textField;
	private JTextField name_textField;
	
	MainBook booky = new MainBook();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.WHITE);
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
		lblNewLabel.setBounds(70, 248, 176, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Person Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(70, 305, 176, 23);
		contentPane.add(lblNewLabel_1);
		
		bookid_textField = new JTextField();
		bookid_textField.setBounds(303, 251, 86, 20);
		contentPane.add(bookid_textField);
		bookid_textField.setColumns(10);
		
		name_textField = new JTextField();
		name_textField.setBounds(303, 308, 86, 20);
		contentPane.add(name_textField);
		name_textField.setColumns(10);
		
		JTextArea show_textArea = new JTextArea();
		show_textArea.setBounds(70, 70, 372, 104);
		contentPane.add(show_textArea);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String j = bookid_textField.getText();
				booky.fileReader();
				List<MainBook> a = booky.map.get(j);
				
				String name = name_textField.getText();

				for (int i = 0; i < a.size(); i++) {
					String str = booky.map.get(j).get(i).getFirstname();
					if (str.equalsIgnoreCase(name)) {
						show_textArea.setCaret((Caret) booky.map.get(j).get(i));
					}
					else {
						JOptionPane.showMessageDialog(null, "Not Found");
					}
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(204, 352, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
