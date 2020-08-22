import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import javax.tools.FileObject;
public class Create extends JFrame{
	
	MainBook booky = new MainBook();

	private JPanel contentPane;
	private JTextField BookID_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				MainBook home = new MainBook();
				home.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(455, 387, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter BOOK ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(120, 151, 139, 54);
		contentPane.add(lblNewLabel);
		
		BookID_textField = new JTextField();
		BookID_textField.setBounds(269, 170, 86, 20);
		contentPane.add(BookID_textField);
		BookID_textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CREATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookID_textField.getText()==null) {
					JOptionPane.showMessageDialog(null, "Empty Field");
				}
				else {
					booky.addressbook[booky.numberofaddressbook]=BookID_textField.getText();
					booky.map.put(booky.addressbook[booky.numberofaddressbook], new LinkedList<MainBook>());
					booky.numberofaddressbook++;
					booky.fileWriter();
					JOptionPane.showMessageDialog(null, "Address Book Created!");
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(198, 216, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD PERSON");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				AddNew newentry = new AddNew();
				newentry.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(405, 11, 139, 23);
		contentPane.add(btnNewButton_2);
	}
}
