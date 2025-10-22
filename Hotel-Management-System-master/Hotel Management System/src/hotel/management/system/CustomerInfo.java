package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class CustomerInfo extends JFrame {
	private Connection conn = null;
	private JPanel contentPane;
	public JLabel lblId;
	public JLabel lblNewLabel;
	public JLabel lblGender;
	public JTable table;
	public JLabel lblCountry;
	public JLabel lblRoom;
	public JLabel lblStatus;
	public JLabel lblNewLabel_1;
	private JButton btnExit;
	private JButton btnLoadData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
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
	public CustomerInfo() throws SQLException {
		// conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Back Button
		btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
		btnExit.setBounds(450, 510, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Load Data Button
		btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(arg0 -> {
			try {
				conn c = new conn();
				String displayCustomersql = "select * from Customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btnLoadData.setBounds(300, 510, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// Labels
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);

		JLabel l1 = new JLabel("Number");
		l1.setBounds(150, 11, 46, 14);
		contentPane.add(l1);

		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(270, 11, 65, 14);
		contentPane.add(lblNewLabel);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 11, 46, 14);
		contentPane.add(lblGender);

		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);

		lblCountry = new JLabel("Country");
		lblCountry.setBounds(480, 11, 46, 14);
		contentPane.add(lblCountry);

		lblRoom = new JLabel("Room");
		lblRoom.setBounds(600, 11, 46, 14);
		contentPane.add(lblRoom);

		lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(680, 11, 100, 14);
		contentPane.add(lblStatus);

		lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		contentPane.add(lblNewLabel_1);

		getContentPane().setBackground(Color.WHITE);
	}

	// Getter for Back Button
	public JButton getBackButton() {
		return btnExit;
	}

	// Getter for Load Data Button
	public JButton getLoadDataButton() {
		return btnLoadData;
	}

	// Getter for JTable
	public JTable getTable() {
		return table;
	}
}
