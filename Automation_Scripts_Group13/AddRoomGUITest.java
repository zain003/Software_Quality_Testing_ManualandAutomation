package hotel.management.system.automatedTests;

import hotel.management.system.AddRoom;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JComboBoxFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddRoomGUITest {
    private FrameFixture window;

    @Before
    public void setUp() {
        AddRoom frame = new AddRoom();
        frame.setName("frame3");
        frame.setVisible(true);
        window = new FrameFixture(frame);
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testRoomNumberField() {
        JTextComponentFixture roomNumberField = window.textBox("roomNumberField");
        roomNumberField.requireEnabled();
        roomNumberField.requireEmpty();

        // Simulate typing in the Room Number field
        roomNumberField.enterText("101");
        roomNumberField.requireText("101");
    }

    @Test
    public void testAvailabilityComboBox() {
        JComboBoxFixture availabilityComboBox = window.comboBox("availabilityComboBox");
        availabilityComboBox.requireEnabled();
        availabilityComboBox.requireSelection("Available");

        // Simulate changing the selection
        availabilityComboBox.selectItem("Occupied");
        availabilityComboBox.requireSelection("Occupied");
    }

    @Test
    public void testCleaningStatusComboBox() {
        JComboBoxFixture cleaningStatusComboBox = window.comboBox("cleaningStatusComboBox");
        cleaningStatusComboBox.requireEnabled();
        cleaningStatusComboBox.requireSelection("Cleaned");

        // Simulate changing the selection
        cleaningStatusComboBox.selectItem("Dirty");
        cleaningStatusComboBox.requireSelection("Dirty");
    }

    @Test
    public void testPriceField() {
        JTextComponentFixture priceField = window.textBox("priceField");
        priceField.requireEnabled();
        priceField.requireEmpty();

        // Simulate entering a price
        priceField.enterText("5000");
        priceField.requireText("5000");
    }

    @Test
    public void testBedTypeComboBox() {
        JComboBoxFixture bedTypeComboBox = window.comboBox("bedTypeComboBox");
        bedTypeComboBox.requireEnabled();
        bedTypeComboBox.requireSelection("Single Bed");

        // Change selection to "Double Bed"
        bedTypeComboBox.selectItem("Double Bed");
        window.robot().waitForIdle(); // Wait for UI update
        bedTypeComboBox.requireSelection("Double Bed");

        // Debugging: Print the selected item
        System.out.println("Selected item after change: " + bedTypeComboBox.selectedItem());
    }


    @Test
    public void testAddButton() {
        // Check if Add button is enabled and visible
        window.button("addButton").requireEnabled().requireVisible();

        // Simulate a click on the Add button
        window.button("addButton").click();

        // Additional checks or mock verifications can go here
    }

    @Test
    public void testBackButton() {
        // Check if Back button is enabled and visible
        window.button("backButton").requireEnabled().requireVisible();

        // Simulate a click on the Back button
        window.button("backButton").click();

        // Additional checks or mock verifications can go here
    }
}
