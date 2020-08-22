import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField newadd_textField;
	private JTextField newcity_textField;
	private JTextField newstate_textField;
	private JTextField newzip_textField;
	private JTextField newphone_textField;
	private JTextField bookid_textField;
	private JTextField phone_textField;
	
	MainBook booky = new MainBook();
	
	List<MainBook> a = new LinkedList<MainBook>();
	String keys = null;
	String phone = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
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
		
		bookid_textField = new JTextField();
		bookid_textField.setBounds(104, 50, 86, 20);
		contentPane.add(bookid_textField);
		bookid_textField.setColumns(10);
		
		phone_textField = new JTextField();
		phone_textField.setBounds(344, 50, 86, 20);
		contentPane.add(phone_textField);
		phone_textField.setColumns(10);
		
		JButton enter_btn = new JButton("ENTER");
		enter_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keys = bookid_textField.getText();
				booky.fileReader();
				a = booky.map.get(keys);
				phone = phone_textField.getText();
			}
		});
		enter_btn.setBackground(Color.WHITE);
		enter_btn.setBounds(455, 49, 89, 23);
		contentPane.add(enter_btn);
		
		JLabel lblNewLabel = new JLabel("ADDRESS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(138, 109, 94, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CITY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(138, 163, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STATE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(138, 208, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ZIP");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(138, 252, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PHONE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(138, 297, 94, 23);
		contentPane.add(lblNewLabel_4);
		
		newadd_textField = new JTextField();
		newadd_textField.setBounds(242, 112, 86, 20);
		contentPane.add(newadd_textField);
		newadd_textField.setColumns(10);
		
		newcity_textField = new JTextField();
		newcity_textField.setBounds(242, 162, 86, 20);
		contentPane.add(newcity_textField);
		newcity_textField.setColumns(10);
		
		newstate_textField = new JTextField();
		newstate_textField.setBounds(242, 207, 86, 20);
		contentPane.add(newstate_textField);
		newstate_textField.setColumns(10);
		
		newzip_textField = new JTextField();
		newzip_textField.setBounds(242, 251, 86, 20);
		contentPane.add(newzip_textField);
		newzip_textField.setColumns(10);
		
		newphone_textField = new JTextField();
		newphone_textField.setBounds(242, 300, 86, 20);
		contentPane.add(newphone_textField);
		newphone_textField.setColumns(10);
		
		JButton add_update_btn = new JButton("UPDATE");
		add_update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<a.size(); i++) {
					String str = booky.map.get(keys).get(i).getPhone();
					if (str.equalsIgnoreCase(phone)) {
						MainBook obj = booky.map.get(keys).get(i);
						String address = newadd_textField.getText();
						obj.setAddress(address);
						booky.fileWriter();
						JOptionPane.showMessageDialog(null, "Address Updated!");	
					}
				}
			}
		});
		add_update_btn.setBackground(Color.WHITE);
		add_update_btn.setBounds(375, 111, 89, 23);
		contentPane.add(add_update_btn);
		
		JButton city_update_btn = new JButton("UPDATE");
		city_update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<a.size(); i++) {
					String str = booky.map.get(keys).get(i).getPhone();
					if (str.equalsIgnoreCase(phone)) {
						MainBook obj = booky.map.get(keys).get(i);
						String city = newcity_textField.getText();
						obj.setAddress(city);
						booky.fileWriter();
						JOptionPane.showMessageDialog(null, "City Updated!");	
					}
				}
			}
		});
		city_update_btn.setBackground(Color.WHITE);
		city_update_btn.setBounds(375, 161, 89, 23);
		contentPane.add(city_update_btn);
		
		JButton state_update_btn = new JButton("UPDATE");
		state_update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<a.size(); i++) {
					String str = booky.map.get(keys).get(i).getPhone();
					if (str.equalsIgnoreCase(phone)) {
						MainBook obj = booky.map.get(keys).get(i);
						String state = newstate_textField.getText();
						obj.setAddress(state);
						booky.fileWriter();
						JOptionPane.showMessageDialog(null, "State Updated!");	
					}
				}
			}
		});
		state_update_btn.setBackground(Color.WHITE);
		state_update_btn.setBounds(375, 206, 89, 23);
		contentPane.add(state_update_btn);
		
		JButton zip_upadte_btn = new JButton("UPDATE");
		zip_upadte_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<a.size(); i++) {
					String str = booky.map.get(keys).get(i).getPhone();
					if (str.equalsIgnoreCase(phone)) {
						MainBook obj = booky.map.get(keys).get(i);
						String zip = newzip_textField.getText();
						obj.setAddress(zip);
						booky.fileWriter();
						JOptionPane.showMessageDialog(null, "Zip Updated!");	
					}
				}
			}
		});
		zip_upadte_btn.setBackground(Color.WHITE);
		zip_upadte_btn.setBounds(375, 250, 89, 23);
		contentPane.add(zip_upadte_btn);
		
		JButton phone_update_btn = new JButton("UPDATE");
		phone_update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<a.size(); i++) {
					String str = booky.map.get(keys).get(i).getPhone();
					if (str.equalsIgnoreCase(phone)) {
						MainBook obj = booky.map.get(keys).get(i);
						String ph = newphone_textField.getText();
						obj.setAddress(ph);
						booky.fileWriter();
						JOptionPane.showMessageDialog(null, "Phone Updated!");	
					}
				}
			}
		});
		phone_update_btn.setBackground(Color.WHITE);
		phone_update_btn.setBounds(375, 299, 89, 23);
		contentPane.add(phone_update_btn);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Book ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 47, 109, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Phone Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(198, 49, 170, 18);
		contentPane.add(lblNewLabel_6);
	}

}
