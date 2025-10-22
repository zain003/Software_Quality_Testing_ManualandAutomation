package hotel.management.system.automatedTests;

import hotel.management.system.Login;


import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginGUITest {
    private FrameFixture window;

    @Before
    public void setUp() {
        Login frame = new Login();
        frame.setName("loginFrame");
        frame.setVisible(true);
        window = new FrameFixture(frame);
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testUsernameField() {
        // Check that the username field is enabled and empty initially
        JTextComponentFixture usernameField = window.textBox("usernameField");
        usernameField.requireEnabled();
        usernameField.requireEmpty();

        // Simulate entering a username
        usernameField.enterText("testUser");
        usernameField.requireText("testUser");
    }

    @Test
    public void testPasswordField() {
        // Interact with the password field using JTextComponentFixture
        JTextComponentFixture passwordField = window.textBox("passwordField");
        passwordField.requireEnabled();
        passwordField.requireEmpty();

        // Simulate entering a password
        passwordField.enterText("testPass");
        passwordField.requireText("testPass");
    }

    @Test
    public void testLoginButton() {
        // Check that the Login button is enabled and visible
        window.button("loginButton").requireEnabled().requireVisible();

        // Simulate a login action
        window.textBox("usernameField").enterText("admin");
        window.textBox("passwordField").enterText("admin123");
        window.button("loginButton").click();

        // Additional assertions: Verify frame transition or mock the database behavior
    }
    @Test
    public void testCancelButton() {
        Login loginFrame = (Login) window.target(); // Get the Login frame
        JButton cancelButton = loginFrame.getCancelButton();

        // Mock the button's action to prevent System.exit
        for (ActionListener listener : cancelButton.getActionListeners()) {
            cancelButton.removeActionListener(listener);
        }
        cancelButton.addActionListener(e -> System.out.println("Mock Cancel Action Triggered"));

        // Simulate a click on the Cancel button
        window.button("cancelButton").click();

        // Validate expected behavior
        System.out.println("Cancel button test completed without affecting other tests.");
    }


    // Custom SecurityManager to prevent System.exit() from terminating the JVM
    public static class NoExitSecurityManager extends SecurityManager {
        @Override
        public void checkPermission(java.security.Permission perm) {
            // Allow all permissions except for System.exit()
            if (perm.getName().startsWith("exitVM")) {
                throw new SecurityException("Exit is not allowed in test");
            }
        }
    }
}
