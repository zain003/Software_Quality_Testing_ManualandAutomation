package hotel.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagerInfo extends JFrame {
	// Connection object for the database (currently commented out)
	Connection conn = null;

	// GUI components
	private JPanel contentPane;
	public JTable table;
	public JLabel lblNewLabel;
	public JLabel lblJob;
	public JLabel lblName;
	public JLabel lblDepartment;

	// Buttons
	private JButton btnLoadData;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInfo frame = new ManagerInfo();
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
	public ManagerInfo() throws SQLException {
		// Uncomment and use your actual database connection when ready.
		// conn = Javaconnect.getDBConnection();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Table for displaying data
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);

		// Load Data Button
		btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn c = new conn(); // Uncomment when actual connection is available
					String displayCustomersql = "select * from Employee where job = 'Manager'";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// Back Button
		btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true); // Assuming Reception is another JFrame class
				setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Labels for table column headers
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);

		lblJob = new JLabel("Age");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);

		lblName = new JLabel("Gender");
		lblName.setBounds(273, 11, 46, 14);
		contentPane.add(lblName);

		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(416, 11, 86, 14);
		contentPane.add(lblDepartment);

		// Additional labels for other employee attributes
		JLabel l1 = new JLabel("Salary");
		l1.setBounds(536, 11, 86, 14);
		contentPane.add(l1);

		JLabel l2 = new JLabel("Phone");
		l2.setBounds(656, 11, 86, 14);
		contentPane.add(l2);

		JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(786, 11, 86, 14);
		contentPane.add(l3);

		JLabel l4 = new JLabel("Gmail");
		l4.setBounds(896, 11, 86, 14);
		contentPane.add(l4);

		// Background color
		getContentPane().setBackground(Color.WHITE);
	}

	// Getter methods to access buttons (for unit testing)
	public JButton getBtnLoadData() {
		return btnLoadData;
	}

	public JButton getBtnExit() {
		return btnExit;
	}
}
