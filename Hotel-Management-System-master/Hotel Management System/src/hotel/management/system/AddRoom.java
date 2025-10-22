package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener {

    public JPanel contentPane;
    public JTextField t4;
    public JTextField t2;
    public JComboBox comboBox;
    public JComboBox comboBox_2;
    public JComboBox comboBox_3;
    public JButton b1;
    public JButton b2;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }
    public AddRoom() {
        setBounds(450, 200, 1000, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);

        t4 = new JTextField();
        t4.setBounds(174, 70, 156, 20);
        t4.setName("roomNumberField"); // Assign a name
        contentPane.add(t4);

        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);

        comboBox = new JComboBox(new String[]{"Available", "Occupied"});
        comboBox.setBounds(176, 110, 154, 20);
        comboBox.setName("availabilityComboBox"); // Assign a name
        contentPane.add(comboBox);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);

        comboBox_2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        comboBox_2.setBounds(176, 150, 154, 20);
        comboBox_2.setName("cleaningStatusComboBox"); // Assign a name
        contentPane.add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(174, 190, 156, 20);
        t2.setName("priceField"); // Assign a name
        contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        contentPane.add(l5);

        comboBox_3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        comboBox_3.setBounds(176, 230, 154, 20);
        comboBox_3.setName("bedTypeComboBox"); // Assign a name
        contentPane.add(comboBox_3);

        b1 = new JButton("Add");
        b1.setBounds(64, 321, 111, 33);
        b1.setName("addButton"); // Assign a name
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(198, 321, 111, 33);
        b2.setName("backButton"); // Assign a name
        contentPane.add(b2);

        contentPane.setBackground(Color.WHITE);
    }


    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                String room = t4.getText();
                String available = (String) comboBox.getSelectedItem();
                String status = (String) comboBox_2.getSelectedItem();
                String price = t2.getText();
                String type = (String) comboBox_3.getSelectedItem();

                // Validate that the price is numeric
                if (!price.matches("\\d+")) { // Only digits allowed
                    JOptionPane.showMessageDialog(null, "Price must be numeric.");
                    return; // Stop further execution
                }

                try {
                    conn c = new conn();
                    String str = "INSERT INTO room values('" + room + "', '" + available + "', '" + status + "','" + price + "', '" + type + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception eee) {
            System.out.println(eee);
        }
    }


    // Public getter methods
    public JPanel getContentPanePanel() {
        return contentPane;
    }

    public JTextField getRoomNumberField() {
        return t4;
    }

    public JTextField getPriceField() {
        return t2;
    }

    public JComboBox getAvailabilityComboBox() {
        return comboBox;
    }

    public JComboBox getCleaningStatusComboBox() {
        return comboBox_2;
    }

    public JComboBox getBedTypeComboBox() {
        return comboBox_3;
    }

    public JButton getAddButton() {
        return b1;
    }

    public JButton getBackButton() {
        return b2;
    }
}
