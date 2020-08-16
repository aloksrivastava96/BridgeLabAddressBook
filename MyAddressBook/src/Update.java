import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bridgelabz.model.Person;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int ch = 0;
		char choice;

		System.out.println("LastnameEnter the Key");
		String keys = scanner.next();
		fileReader();
		List<Person> a = map.get(keys);
		System.out.println(a);
		System.out.println("Enter the phone number for updation");
		String phone = scanner.next();
		for (int i = 0; i < a.size(); i++) {
			String str = map.get(keys).get(i).getPhone();
			if (str.equalsIgnoreCase(phone)) {
				Person obj = map.get(keys).get(i);
				System.out.println("Hi User, Please select field you need to edit..!");
				do {
					System.out.println("1. Change Address");
					System.out.println("2. Change City");
					System.out.println("3. Change State");
					System.out.println("4. Change Zipcode");
					System.out.println("5. change Phone Number");

					ch = scanner.nextInt();

					switch (ch) {
					case 1:
						System.out.println("Enter your Address");
						String address = scanner.next();
						obj.setAddress(address);
						fileWriter();
						System.out.println("Address Updated");
						break;
					case 2:
						System.out.println("Enter your City ");
						String city = scanner.next();
						obj.setCity(city);
						fileWriter();
						System.out.println("City Updated");
						break;
					case 3:
						System.out.println("Enter your State");
						String state = scanner.next();
						obj.setState(state);
						fileWriter();
						System.out.println("State Updated");
						break;
					case 4:
						System.out.println("Enter Your Zipcode");
						String zipcode = scanner.next();
						obj.setZip(zipcode);
						fileWriter();
						System.out.println("Zipcode Updated");
						break;
					case 5:
						System.out.println("Enter Phone Number");
						String phone1 = scanner.next();
						obj.setPhone(phone1);
						fileWriter();
						System.out.println("Phone Number Updated");
						break;

					}

					System.out.println("Do You want to continue");
					choice = scanner.next().charAt(0);

				} while (choice == 'Y' || choice == 'y');
			} else {
				System.out.println("Contact doesn't exist");
			}

		}
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainBook home = new MainBook();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(169, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
