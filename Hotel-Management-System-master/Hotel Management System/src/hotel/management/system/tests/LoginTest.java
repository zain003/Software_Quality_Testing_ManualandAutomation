/*package hotel.management.system.tests;



import hotel.management.system.Login;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class LoginTest {

    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login();

    }

    @AfterEach
    void tearDown() {
        login.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(600, login.getWidth(), "Frame width should be 600");
        assertEquals(300, login.getHeight(), "Frame height should be 300");
        assertEquals(Color.WHITE, login.getContentPane().getBackground(), "Background color should be white");
        assertEquals("Login", login.getTitle(), "Frame title should be 'Login'");
    }

    @Test
    void testLabelInitialization() {
        JLabel usernameLabel = login.l1;
        assertNotNull(usernameLabel, "Username label should be initialized");
        assertEquals("Username", usernameLabel.getText(), "Username label text should be 'Username'");
        assertEquals(40, usernameLabel.getX(), "Username label x-coordinate should be 40");
        assertEquals(20, usernameLabel.getY(), "Username label y-coordinate should be 20");

        JLabel passwordLabel = login.l2;
        assertNotNull(passwordLabel, "Password label should be initialized");
        assertEquals("Password", passwordLabel.getText(), "Password label text should be 'Password'");
        assertEquals(40, passwordLabel.getX(), "Password label x-coordinate should be 40");
        assertEquals(70, passwordLabel.getY(), "Password label y-coordinate should be 70");
    }

    @Test
    void testTextFieldInitialization() {
        JTextField usernameField = login.t1;
        assertNotNull(usernameField, "Username text field should be initialized");
        assertEquals(150, usernameField.getX(), "Username text field x-coordinate should be 150");
        assertEquals(20, usernameField.getY(), "Username text field y-coordinate should be 20");

        JPasswordField passwordField = login.t2;
        assertNotNull(passwordField, "Password field should be initialized");
        assertEquals(150, passwordField.getX(), "Password field x-coordinate should be 150");
        assertEquals(70, passwordField.getY(), "Password field y-coordinate should be 70");
    }

    @Test
    void testButtonInitialization() {
        JButton loginButton = login.b1;
        assertNotNull(loginButton, "Login button should be initialized");
        assertEquals("Login", loginButton.getText(), "Login button text should be 'Login'");
        assertEquals(40, loginButton.getX(), "Login button x-coordinate should be 40");
        assertEquals(140, loginButton.getY(), "Login button y-coordinate should be 140");

        JButton cancelButton = login.b2;
        assertNotNull(cancelButton, "Cancel button should be initialized");
        assertEquals("Cancel", cancelButton.getText(), "Cancel button text should be 'Cancel'");
        assertEquals(180, cancelButton.getX(), "Cancel button x-coordinate should be 180");
        assertEquals(140, cancelButton.getY(), "Cancel button y-coordinate should be 140");
    }

    @Test
    void testActionPerformed_LoginButton() {
        // Simulate login action
        login.t1.setText("admin"); // Set username
        login.t2.setText("password123"); // Set password

        ActionEvent loginEvent = new ActionEvent(login.b1, ActionEvent.ACTION_PERFORMED, "Login");
        assertDoesNotThrow(() -> login.actionPerformed(loginEvent), "Login action should not throw any exception");
    }

    @Test
    void testActionPerformed_CancelButton() {
        // Simulate cancel action
        ActionEvent cancelEvent = new ActionEvent(login.b2, ActionEvent.ACTION_PERFORMED, "Cancel");
        assertDoesNotThrow(() -> login.actionPerformed(cancelEvent), "Cancel action should not throw any exception");

        // Verify that the application exits (System.exit(0))
        // Note: System.exit() cannot be easily tested without additional frameworks or utilities
    }

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> Login.main(new String[]{}), "Main method should execute without exceptions");
    }
}*/
