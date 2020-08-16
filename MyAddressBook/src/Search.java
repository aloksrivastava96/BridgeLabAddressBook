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

public class Search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Enter the key");
		String j = scanner.next();
		fileReader();
		List<Person> a = map.get(j);

		System.out.println("Enter the First name you want to search");
		String name = scanner.next();

		for (int i = 0; i < a.size(); i++) {
			String str = map.get(j).get(i).getFirstname();
			if (str.equalsIgnoreCase(name)) {
				System.out.println(map.get(j).get(i));
				return;
			}
			System.out.println("Contact Not Found");
		}
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
		btnNewButton.setBounds(173, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
