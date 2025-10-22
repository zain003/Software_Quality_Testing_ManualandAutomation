package hotel.management.system.tests;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import hotel.management.system.CustomerInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import javax.swing.JTable;

public class CustomerInfoTest {

    private CustomerInfo customerInfo;

    @BeforeEach
    public void setup() throws Exception {
        customerInfo = new CustomerInfo();
    }

    @Test
    public void testBackButtonPresence() {
        // Ensure that the Back button is initialized properly and is not null
        JButton backButton = customerInfo.getBackButton();
        assertNotNull(backButton, "Back button is missing.");
    }

    @Test
    public void testLoadDataButtonPresence() {
        // Ensure that the Load Data button is initialized properly and is not null
        JButton loadDataButton = customerInfo.getLoadDataButton();
        assertNotNull(loadDataButton, "Load Data button is missing.");
    }

    @Test
    public void testTablePresence() {
        // Ensure that the table is initialized properly and is not null
        JTable table = customerInfo.getTable();
        assertNotNull(table, "Table is missing.");
    }

    @Test
    public void testBackButtonAction() {
        // Simulate button click and test action for Back button
        JButton backButton = customerInfo.getBackButton();
        backButton.doClick();  // Simulate button click
        // Add assertions to check if the expected action is performed
        // This might involve checking if the Reception window is shown
    }

    @Test
    public void testLoadDataButtonAction() {
        // Simulate button click and test action for Load Data button
        JButton loadDataButton = customerInfo.getLoadDataButton();
        loadDataButton.doClick();  // Simulate button click
        // Add assertions to check if the data is loaded into the table
        // This might involve verifying if the table model was updated correctly
    }
}
