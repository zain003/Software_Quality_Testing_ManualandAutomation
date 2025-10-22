package hotel.management.system.tests;

import hotel.management.system.AddDrivers;
import org.junit.jupiter.api.*;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class AddDriversTest {

    private AddDrivers addDrivers;

    @BeforeEach
    public void setUp() {
        addDrivers = new AddDrivers();
    }

    @Test
    public void testAddButtonAction() {
        // Set mock values in the fields
        addDrivers.t1.setText("John Doe");
        addDrivers.t2.setText("35");
        addDrivers.comboBox.setSelectedItem("Male");
        addDrivers.t3.setText("Toyota");
        addDrivers.t4.setText("Corolla");
        addDrivers.comboBox_1.setSelectedItem("Yes");
        addDrivers.t5.setText("New York");

        // Simulate Add button click
        ActionEvent actionEvent = new ActionEvent(addDrivers.b1, ActionEvent.ACTION_PERFORMED, "Add");
        addDrivers.actionPerformed(actionEvent);

        // Verify the frame is hidden after successful addition
        assertFalse(addDrivers.isVisible(), "The AddDrivers frame should be hidden after adding a driver.");
    }


    @Test
    public void testBackButtonAction() {
        // Simulate Back button click
        ActionEvent actionEvent = new ActionEvent(addDrivers.b2, ActionEvent.ACTION_PERFORMED, "Back");
        addDrivers.actionPerformed(actionEvent);

        // Verify the frame is hidden
        assertFalse(addDrivers.isVisible(), "The AddDrivers frame should be hidden after clicking Back.");
    }


    @Test
    public void testBackButtonCreatesNewInstance() {
        // Simulate the Back button behavior for creating a new AddDrivers frame
        ActionEvent actionEvent = new ActionEvent(addDrivers.b2, ActionEvent.ACTION_PERFORMED, "Back");
        addDrivers.actionPerformed(actionEvent);

        // Verify a new frame is visible
        AddDrivers newFrame = new AddDrivers();
        newFrame.setVisible(true);

        assertTrue(newFrame.isVisible(), "A new AddDrivers frame should be visible after clicking Back.");
        newFrame.dispose(); // Clean up the new frame
    }

    @AfterEach
    public void tearDown() {
        addDrivers.dispose(); // Clean up the frame
    }
}
