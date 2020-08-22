import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class Remove extends JFrame {

	private JPanel contentPane;
	private JTextField bookid_textField;
	private JTextField phone_textField;
	
	MainBook booky = new MainBook();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove frame = new Remove();
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
	public Remove() {
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
		
		JLabel lblNewLabel = new JLabel("Enter the BOOK ID ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(115, 108, 199, 46);
		contentPane.add(lblNewLabel);
		
		bookid_textField = new JTextField();
		bookid_textField.setBounds(324, 123, 86, 20);
		contentPane.add(bookid_textField);
		bookid_textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookid = bookid_textField.getText();
				booky.fileReader();
				booky.list = booky.map.get(bookid);
				
				String phone = phone_textField.getText();
				for (int i = 0; i < booky.list.size(); i++) {
					if (phone.equals(booky.list.get(i).getPhone())) {
						booky.list.remove(i);
					}
				}

				booky.fileWriter();
				
				JOptionPane.showMessageDialog(null, "Removed Successfully");
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(225, 235, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Phone Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(115, 176, 199, 46);
		contentPane.add(lblNewLabel_1);
		
		phone_textField = new JTextField();
		phone_textField.setBounds(324, 191, 86, 20);
		contentPane.add(phone_textField);
		phone_textField.setColumns(10);
	}
}
