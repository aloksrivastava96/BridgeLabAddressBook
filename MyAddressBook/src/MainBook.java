import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainBook {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File file = new File("filestorage.ser");
		if(!file.exists()) {
			try {
				boolean newfile = file.createNewFile();
				System.out.println(newfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.exists());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainBook window = new MainBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 556, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Create c = new Create();
				c.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(59, 80, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bridgelab.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(142, 105, 260, 220);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddNew ad = new AddNew();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(397, 80, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Remove rem = new Remove();
				rem.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(59, 330, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Update up = new Update();
				up.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(397, 330, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DISPLAY");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Display d = new Display();
				d.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(227, 40, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("SORT_NAME");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SortByName sortn = new SortByName();
				sortn.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(10, 204, 127, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("SORT_ZIP");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SortByZip sortz = new SortByZip();
				sortz.setVisible(true);
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(407, 204, 127, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("SEARCH");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search ser = new Search();
				ser.setVisible(true);
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(227, 360, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
	}
}
