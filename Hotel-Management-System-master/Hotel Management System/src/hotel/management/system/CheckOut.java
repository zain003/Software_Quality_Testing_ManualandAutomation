package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class CheckOut extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1; // Room number text field
	private Choice c1; // Customer number choice
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public CheckOut() throws SQLException {
		// conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Image setup for the frame
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
		Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(300, 0, 500, 225);
		add(l1);

		// Title label
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);

		// Customer number label
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);

		// Choice dropdown for customer numbers
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) { }
		c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);

		// Fetch button setup
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
		Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JButton l2 = new JButton(i6);
		l2.setBounds(290, 82, 20, 20);
		add(l2);

		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					conn c = new conn();
					String number = c1.getSelectedItem();
					// Use 'roomnumber' instead of 'room_number'
					ResultSet rs = c.s.executeQuery("select * from customer where number = " + number);

					if (rs.next()) {
						// Use 'roomnumber' instead of 'room_number'
						t1.setText(rs.getString("roomnumber"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Room number label
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);

		// Room number text field
		t1 = new JTextField();
		t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);

		// Check Out button setup
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = c1.getSelectedItem();
				String s1 = t1.getText();
				// Use 'roomnumber' instead of 'room_number'
				String deleteSQL = "Delete from customer where number = " + id;
				// Use 'roomnumber' instead of 'room_number'
				String q2 = "update room set availability = 'Available' where roomnumber = " + s1;

				conn c = new conn();

				try {
					c.s.executeUpdate(deleteSQL);
					c.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "Check Out Successful");
					new Reception().setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
		btnCheckOut.setBackground(Color.BLACK);
		btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);

		// Back button setup
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		backButton.setBounds(160, 200, 100, 25);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		contentPane.add(backButton);

		// Set background color
		getContentPane().setBackground(Color.WHITE);
	}
	// Add this method to CheckOut class
	public void populateChoice(String[] items) {
		c1.removeAll(); // Clear existing items
		for (String item : items) {
			c1.add(item); // Add new items
		}
	}


	// Getter for the customer number Choice
	public Choice getChoice() {
		return c1;
	}

	// Getter for the room number text field
	public JTextField getRoomNumberField() {
		return t1;
	}
	// Getter for the fetch button
	public JButton getFetchButton() {
		Component component = contentPane.getComponent(3); // l2 is the fetch button
		if (component instanceof JButton) {
			return (JButton) component;
		} else {
			throw new ClassCastException("Component at index 3 is not a JButton");
		}
	}

	// Getter for the check-out button
	public JButton getCheckOutButton() {
		return (JButton) contentPane.getComponent(8); // btnCheckOut is the check-out button
	}

	// Getter for the back button
	public JButton getBackButton() {
		return backButton; // Direct reference to backButton variable
	}
}
