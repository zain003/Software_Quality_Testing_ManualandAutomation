package hotel.management.system.tests;


import hotel.management.system.Reception;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

class ReceptionTest {

    private Reception reception;

    @BeforeEach
    void setUp() {
        reception = new Reception();
        reception.setVisible(false); // Prevent UI display during tests
    }

    @AfterEach
    void tearDown() {
        reception.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(850, reception.getWidth(), "Frame width should be 850");
        assertEquals(570, reception.getHeight(), "Frame height should be 570");
        assertNotNull(reception.getContentPane(), "Content pane should be initialized");
        assertEquals(Color.WHITE, reception.getContentPane().getBackground(), "Frame background color should be white");
    }







    @Test
    void testLogOutButtonFunctionality() {
        JButton btnLogOut = (JButton) reception.getContentPane().getComponent(12);

        // Simulate button click
        assertDoesNotThrow(() -> btnLogOut.doClick(), "Clicking the Log Out button should not throw an exception");

        // Assert that the reception frame is no longer visible
        assertFalse(reception.isVisible(), "Reception frame should not be visible after logging out");
    }
}
