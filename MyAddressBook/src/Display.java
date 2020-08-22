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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Display extends JFrame {

	private JPanel contentPane;
	private JTextField getbookid_textField;
	
	MainBook booky = new MainBook();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
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
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 460);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
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
		
		JTextArea display_textArea = new JTextArea();
		display_textArea.setBounds(103, 55, 348, 310);
		contentPane.add(display_textArea);
		
		JLabel lblNewLabel = new JLabel("Enter the Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(89, 21, 127, 23);
		contentPane.add(lblNewLabel);
		
		getbookid_textField = new JTextField();
		getbookid_textField.setBounds(226, 24, 86, 20);
		contentPane.add(getbookid_textField);
		getbookid_textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booky.fileReader();
				String bookid = getbookid_textField.getText();
				List<MainBook> a = booky.map.get(bookid);
				display_textArea.setText("Firstname \tLastname \tAddress \tCity \t\tState \t\tZIP \t\tPhone \n");
				for (int i = 0; i < a.size(); i++) {
					display_textArea.setCaret((Caret) a.get(i));
				}

			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(362, 23, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
