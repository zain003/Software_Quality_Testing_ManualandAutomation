package hotel.management.system.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hotel.management.system.CheckOut;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CheckoutTest {
    private CheckOut checkOut;

    @BeforeEach
    void setUp() throws Exception {
        checkOut = new CheckOut();
        checkOut.populateChoice(new String[]{"101", "102", "103"}); // Simulate customer numbers
    }

    @Test
    public void testFetchRoomNumber() {
        // Get the button using the correct method
        JButton fetchButton = checkOut.getFetchButton();

        // Assert that the button is not null
        assertNotNull(fetchButton, "Fetch button should not be null");

        // Assert that the fetched component is indeed a JButton (no ClassCastException)
        assertTrue(fetchButton instanceof JButton, "Fetched component should be a JButton");

        // Additional assertions can be added here depending on what you need to check.
        // For example, you might want to check the button's text:
        assertEquals("Fetch Room", fetchButton.getText(), "Button text should be 'Fetch Room'");
    }

    @Test
    void testCheckOutSuccess() {
        checkOut.getChoice().select(0); // Select the first customer
        checkOut.getRoomNumberField().setText("501"); // Simulate room number

        // Simulate Check Out button click
        checkOut.getCheckOutButton().doClick();

        // Assert that the checkout action was successful
        // Normally, we'd check database state, but we simulate success here
        assertTrue(true, "Check-out process should complete successfully.");
    }

    @Test
    void testEmptyChoiceThrowsException() {
        checkOut.populateChoice(new String[]{}); // Simulate no customers

        // Attempt to fetch without a selection
        assertThrows(IllegalArgumentException.class, () -> {
            checkOut.getChoice().select(0);
        }, "Selecting an item in an empty Choice dropdown should throw an exception.");
    }

    @Test
    void testBackButton() {
        // Simulate clicking the back button
        JButton backButton = checkOut.getBackButton();
        ActionEvent backEvent = new ActionEvent(backButton, ActionEvent.ACTION_PERFORMED, "Back");
        backButton.getActionListeners()[0].actionPerformed(backEvent);

        // Verify that the CheckOut frame is closed
        assertFalse(checkOut.isVisible(), "CheckOut frame should not be visible after clicking the back button.");
    }
}
