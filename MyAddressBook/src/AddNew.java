import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class AddNew extends JFrame {
	
	MainBook booky = new MainBook();
	
	private JPanel contentPane;
	private JTextField fname_textField;
	private JTextField lname_textField;
	private JTextField address_textField;
	private JTextField city_textField;
	private JTextField state_textField;
	private JTextField zip_textField;
	private JTextField phone_textField;
	private JTextField getbookid_textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew frame = new AddNew();
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
	public AddNew() {
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
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(92, 81, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(92, 118, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(92, 154, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(92, 188, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("State");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(92, 225, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Zip Code");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(92, 261, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(92, 294, 122, 14);
		contentPane.add(lblNewLabel_6);
		
		fname_textField = new JTextField();
		fname_textField.setBounds(285, 77, 100, 20);
		contentPane.add(fname_textField);
		fname_textField.setColumns(10);
		
		lname_textField = new JTextField();
		lname_textField.setBounds(285, 112, 100, 20);
		contentPane.add(lname_textField);
		lname_textField.setColumns(10);
		
		address_textField = new JTextField();
		address_textField.setBounds(285, 148, 100, 20);
		contentPane.add(address_textField);
		address_textField.setColumns(10);
		
		city_textField = new JTextField();
		city_textField.setBounds(285, 182, 100, 20);
		contentPane.add(city_textField);
		city_textField.setColumns(10);
		
		state_textField = new JTextField();
		state_textField.setBounds(285, 219, 100, 20);
		contentPane.add(state_textField);
		state_textField.setColumns(10);
		
		zip_textField = new JTextField();
		zip_textField.setBounds(285, 255, 100, 20);
		contentPane.add(zip_textField);
		zip_textField.setColumns(10);
		
		phone_textField = new JTextField();
		phone_textField.setBounds(285, 288, 100, 20);
		contentPane.add(phone_textField);
		phone_textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fname_textField.getText()==null) {
					JOptionPane.showMessageDialog(null, "First Name cannot be empty");
				}
				else {
					booky.person=new MainBook();
					String bookfname = fname_textField.getText();
					booky.person.setFirstname(bookfname);
					
					String booklname = lname_textField.getText();
					booky.person.setLastname(booklname);
					
					String bookaddress = address_textField.getText();
					booky.person.setAddress(bookaddress);
					
					String bookcity = city_textField.getText();
					booky.person.setCity(bookcity);
					
					String bookstate = state_textField.getText();
					booky.person.setState(bookstate);
					
					String bookzip = zip_textField.getText();
					try {
						Integer.parseInt(bookzip);
						booky.person.setZip(bookzip);
					}
					catch (NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "Zip is NOT a valid integer");
					}
					
					String bookphone = phone_textField.getText();
					try {
						new BigInteger(bookphone);
						booky.person.setPhone(bookphone);
					}
					catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Phone is NOT a valid integer");
					}
					List<MainBook> a = booky.map.get(booky.key);
					a.add(booky.person);
					booky.map.put(booky.key, a);
					booky.fileWriter();
					
					JOptionPane.showMessageDialog(null, "Added Successfully");
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(198, 319, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Book ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(92, 28, 92, 23);
		contentPane.add(lblNewLabel_7);
		
		getbookid_textField_7 = new JTextField();
		getbookid_textField_7.setBounds(198, 31, 86, 20);
		contentPane.add(getbookid_textField_7);
		getbookid_textField_7.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Enter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booky.fileReader();
				booky.key=getbookid_textField_7.getText();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(304, 30, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
