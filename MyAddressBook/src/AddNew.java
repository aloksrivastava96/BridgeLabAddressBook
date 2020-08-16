import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bridgelabz.model.Person;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddNew extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Enter the First name");
		String firstname = scanner.next();
		person.setFirstname(firstname);

		System.out.println("Enter the Last name");
		String lastname = scanner.next();
		person.setLastname(lastname);

		System.out.println("Enter your Address");
		String address = scanner.next();
		person.setAddress(address);

		System.out.println("Enter your City");
		String city = scanner.next();
		person.setCity(city);

		System.out.println("Enter your State");
		String state = scanner.next();
		person.setState(state);

		System.out.println("Enter your Zip Code");
		String zipcode = scanner.next();
		person.setZip(zipcode);

		System.out.println("Enter your Phone Number");
		String phone = scanner.next();
		person.setPhone(phone);

		List<Person> a = map.get(key);

		a.add(person);
		map.put(key, a);
		fileWriter();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainBook home = new MainBook();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(162, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
