package hotel.management.system.tests;


import hotel.management.system.ManagerInfo;
import hotel.management.system.Reception;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

class ManagerInfoTest {

    private ManagerInfo managerInfo;

    @BeforeEach
    void setUp() throws SQLException {
        // Create instance of ManagerInfo (no need to display it during tests)
        managerInfo = new ManagerInfo();
        managerInfo.setVisible(false);
    }

    @AfterEach
    void tearDown() {
        managerInfo.dispose();
    }

    @Test
    void testFrameInitialization() {
        // Verify if the frame is initialized with correct dimensions
        assertEquals(1000, managerInfo.getWidth(), "Frame width should be 1000");
        assertEquals(600, managerInfo.getHeight(), "Frame height should be 600");
    }

    @Test
    void testTableInitialization() {
        // Check if the table is correctly initialized
        JTable table = managerInfo.table;
        assertNotNull(table, "Table should be initialized");
        assertEquals(0, table.getRowCount(), "Table should have 0 rows initially");
    }

    @Test
    void testLabelsInitialization() {
        // Check that all labels are initialized properly
        assertNotNull(managerInfo.lblNewLabel, "Name label should be initialized");
        assertNotNull(managerInfo.lblJob, "Age label should be initialized");
        assertNotNull(managerInfo.lblName, "Gender label should be initialized");
        assertNotNull(managerInfo.lblDepartment, "Job label should be initialized");
    }

    @Test
    void testLoadDataButtonAction() {
        // Simulate the Load Data button click
        JButton btnLoadData = managerInfo.getBtnLoadData();

        // Since database interaction is involved, we would normally mock the database.
        // For now, we simply ensure no exception occurs during the button click event.
        assertDoesNotThrow(() -> btnLoadData.doClick(), "Button click should not throw any exception");

        // Verify that the table is populated with data (mocking data can be added for more thorough testing)
        // Assuming the data is being loaded correctly from the database, this test could be enhanced further.
    }

    @Test
    void testBackButtonAction() {
        // Simulate the Back button click
        JButton btnExit = managerInfo.getBtnExit();

        // Ensure the Back button opens the Reception window
        assertDoesNotThrow(() -> btnExit.doClick(), "Back button click should not throw any exception");

        // Since the Reception window is opened, we would ideally check if the Reception window is now visible.
        // This is a more complex test since the Reception window itself would need to be verified.
    }

    @Test
    void testMainMethod() {
        // Ensure the main method executes without exceptions
        assertDoesNotThrow(() -> ManagerInfo.main(new String[]{}), "Main method should execute without exceptions");
    }
}
