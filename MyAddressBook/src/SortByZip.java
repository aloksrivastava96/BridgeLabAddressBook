import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bridgelabz.model.Person;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class SortByZip extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		fileReader();
		 */
		{
			for (int select = 0; select < numberofaddressbook; select++) {
				System.out.println(select + " " + addressbook[select]);
			}

			System.out.println("Please Select Your address book");
			int select = scanner.nextInt();
			Object keys = addressbook[select];

			// List<Person> a = map.get(j);
			List<Person> arraylist = map.get(keys);
			Collections.sort(arraylist, Person.sortbyname);
			fileWriter();
			for (Person str : arraylist)

			{
				System.out.println(str);
			}

		}
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		btnNewButton.setBounds(176, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
