package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame { // Third Frame

    public JTextField textField;
    public JTextField textField_1;
    public JTextField textField_3;
    public JTextField textField_4;
    public JTextField textField_5;
    public JTextField textField_6;
    public JComboBox<String> c1;
    public JButton btnSave; // Make btnSave an instance variable
    public JRadioButton rbMale, rbFemale; // Make rbMale and rbFemale instance variables

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblName.setBounds(60, 30, 150, 27);
        add(lblName);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        textField.setName("nameField");  // Set the name for testing
        add(textField);

        btnSave = new JButton("SAVE"); // Initialize btnSave as an instance variable
        btnSave.setBounds(200, 420, 150, 30);
        btnSave.setBackground(Color.BLACK);
        btnSave.setForeground(Color.WHITE);
        btnSave.setName("saveButton");  // Set the name for testing
        add(btnSave);

        JLabel lblAge = new JLabel("AGE");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAge.setBounds(60, 80, 150, 27);
        add(lblAge);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        textField_1.setName("ageField");  // Set the name for testing
        add(textField_1);

        JLabel lblGender = new JLabel("GENDER");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblGender.setBounds(60, 120, 150, 27);
        add(lblGender);

        rbMale = new JRadioButton("MALE"); // Initialize rbMale as an instance variable
        rbMale.setBackground(Color.WHITE);
        rbMale.setBounds(200, 120, 70, 27);
        rbMale.setName("maleRadioButton");  // Set the name for testing
        add(rbMale);

        rbFemale = new JRadioButton("FEMALE"); // Initialize rbFemale as an instance variable
        rbFemale.setBackground(Color.WHITE);
        rbFemale.setBounds(280, 120, 70, 27);
        rbFemale.setName("femaleRadioButton");  // Set the name for testing
        add(rbFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        JLabel lblJob = new JLabel("JOB");
        lblJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblJob.setBounds(60, 170, 150, 27);
        add(lblJob);

        String[] jobs = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox<>(jobs);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 170, 150, 30);
        c1.setName("jobComboBox");  // Set the name for testing
        add(c1);

        JLabel lblSalary = new JLabel("SALARY");
        lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblSalary.setBounds(60, 220, 150, 27);
        add(lblSalary);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        textField_3.setName("salaryField");  // Set the name for testing
        add(textField_3);

        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPhone.setBounds(60, 270, 150, 27);
        add(lblPhone);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        textField_4.setName("phoneField");  // Set the name for testing
        add(textField_4);

        JLabel lblAadhar = new JLabel("AADHAR");
        lblAadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAadhar.setBounds(60, 320, 150, 27);
        add(lblAadhar);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        textField_5.setName("aadharField");  // Set the name for testing
        add(textField_5);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEmail.setBounds(60, 370, 150, 27);
        add(lblEmail);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        textField_6.setName("emailField");  // Set the name for testing
        add(textField_6);

        JLabel lblTitle = new JLabel("ADD EMPLOYEE DETAILS");
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblTitle.setBounds(450, 24, 442, 35);
        add(lblTitle);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image scaledImage = icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImage = new JLabel(scaledIcon);
        lblImage.setBounds(410, 80, 480, 410);
        add(lblImage);

        btnSave.addActionListener(ae -> {
            String name = textField.getText();
            String age = textField_1.getText();
            String salary = textField_3.getText();
            String phone = textField_4.getText();
            String aadhar = textField_5.getText();
            String email = textField_6.getText();
            String gender = rbMale.isSelected() ? "male" : rbFemale.isSelected() ? "female" : null;
            String job = (String) c1.getSelectedItem();

            if (name.isEmpty() || age.isEmpty() || salary.isEmpty() || phone.isEmpty() || aadhar.isEmpty() || email.isEmpty() || gender == null || job == null) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }

            try {
                conn c = new conn();
                String query = "INSERT INTO employee (name, age, gender, job, salary, phone, aadhar, email) VALUES ('"
                        + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + aadhar + "', '" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(530, 200);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
