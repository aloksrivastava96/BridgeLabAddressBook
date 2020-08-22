import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.tools.FileObject;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
public class MainBook implements Serializable{
	
	public int numberofaddressbook=0;
	public List<MainBook> list = new LinkedList<MainBook>();
	public Map<String, List<MainBook>> map = new HashMap<String, List<MainBook>>();
	
	public String[] addressbook = new String[10];
	MainBook person;
	//Scanner scanner = new Scanner(System.in);
	public String value = "";
	public String key = "";
	
	@Override
	public String toString() {
		return firstname + "\t\t" + lastname + "\t\t" + address + "\t\t" + city + "\t\t" + state + "\t\t" + zip + "\t\t"
				+ phone;
	}

	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static Comparator<MainBook> sortbyname = new Comparator<MainBook>() {

		public int compare(MainBook s1, MainBook s2) {
			String FirstName1 = (String)s1.getLastname();
			String FirstName2 = (String)s2.getLastname();

			// ascending order
			return FirstName1.compareTo(FirstName2);
		}
	};

	public static Comparator<MainBook> sortbyzip = new Comparator<MainBook>() {
		public int compare(MainBook s1, MainBook s2) {
			String Zip1 = s1.getZip();
			String Zip2 = s2.getZip();

			// ascending order
			return Zip1.compareTo(Zip2);
		}
	};

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File file = new File("filestorage.ser");
		if(!file.exists()) {
			try {
				boolean newfile = file.createNewFile();
				//System.out.println(newfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(file.exists());
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
	
	public void fileWriter() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("filestorage.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.writeObject(addressbook);
			oos.writeInt(numberofaddressbook);
			oos.writeObject(key);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fileReader() {
		try {
			FileInputStream fileInputStream = new FileInputStream("filestorage.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			map = (HashMap) objectInputStream.readObject();

			addressbook = (String[]) objectInputStream.readObject();
			numberofaddressbook = objectInputStream.readInt();
			key = (String) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		btnNewButton_7.setBounds(227, 361, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Create c = new Create();
				c.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(59, 80, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
}
