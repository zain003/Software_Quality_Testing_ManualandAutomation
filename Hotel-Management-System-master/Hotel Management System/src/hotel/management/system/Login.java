package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    public JLabel l1;
    public JLabel l2;
    public JTextField t1;
    public JPasswordField t2;
    public JButton b1;
    public JButton b2;

    public Login() {
        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        t1.setName("usernameField"); // Set name for username field
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        t2.setName("passwordField"); // Set name for password field
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setName("loginButton"); // Set name for login button
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setName("cancelButton"); // Set name for cancel button
        add(b2);

        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600, 300);
        setLocation(600, 350);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where username='" + u + "' and password='" + v + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            // Exit on cancel button
            System.exit(0);
        }
    }

    // Corrected getCancelButton method to return b2
    public JButton getCancelButton() {
        return b2;
    }

    public static void main(String[] arg) {
        new Login();
    }
}
