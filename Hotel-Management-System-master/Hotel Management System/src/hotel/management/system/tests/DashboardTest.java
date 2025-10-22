package hotel.management.system.tests;

import hotel.management.system.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DashboardTest {

    private Dashboard dashboard;

    @BeforeEach
    public void setUp() {
        // Initialize the Dashboard before each test
        dashboard = new Dashboard();
    }

    @Test
    public void testDashboardVisibility() {
        // Test if the Dashboard frame is visible when created
        assertTrue(dashboard.isVisible(), "Dashboard should be visible after initialization.");
    }

    @Test
    public void testMenuBarNotNull() {
        // Test if the menu bar is initialized correctly
        JMenuBar menuBar = dashboard.getJMenuBar();
        assertNotNull(menuBar, "MenuBar should not be null.");
    }

    @Test
    public void testReceptionMenuItemAction() {
        // Test if Reception menu item action opens the Reception frame
        JMenuItem receptionMenuItem = findMenuItemByText(dashboard, "RECEPTION");
        assertNotNull(receptionMenuItem, "Reception menu item should exist.");

        // Simulate the click event on Reception menu item
        ActionListener[] actionListeners = receptionMenuItem.getActionListeners();
        actionListeners[0].actionPerformed(new ActionEvent(receptionMenuItem, ActionEvent.ACTION_PERFORMED, null));

        // Test if Reception window opens
        assertTrue(isWindowOpened(Reception.class), "Reception window should open when RECEPTION menu item is clicked.");
    }

    @Test
    public void testAddEmployeeMenuItemAction() {
        // Test if Add Employee menu item action opens the AddEmployee frame
        JMenuItem addEmployeeMenuItem = findMenuItemByText(dashboard, "ADD EMPLOYEE");
        assertNotNull(addEmployeeMenuItem, "Add Employee menu item should exist.");

        // Simulate the click event on Add Employee menu item
        ActionListener[] actionListeners = addEmployeeMenuItem.getActionListeners();
        actionListeners[0].actionPerformed(new ActionEvent(addEmployeeMenuItem, ActionEvent.ACTION_PERFORMED, null));

        // Test if AddEmployee window opens
        assertTrue(isWindowOpened(AddEmployee.class), "AddEmployee window should open when ADD EMPLOYEE menu item is clicked.");
    }

    @Test
    public void testAddRoomMenuItemAction() {
        // Test if Add Room menu item action opens the AddRoom frame
        JMenuItem addRoomMenuItem = findMenuItemByText(dashboard, "ADD ROOMS");
        assertNotNull(addRoomMenuItem, "Add Room menu item should exist.");

        // Simulate the click event on Add Room menu item
        ActionListener[] actionListeners = addRoomMenuItem.getActionListeners();
        actionListeners[0].actionPerformed(new ActionEvent(addRoomMenuItem, ActionEvent.ACTION_PERFORMED, null));

        // Test if AddRoom window opens
        assertTrue(isWindowOpened(AddRoom.class), "AddRoom window should open when ADD ROOMS menu item is clicked.");
    }

    @Test
    public void testAddDriversMenuItemAction() {
        // Test if Add Drivers menu item action opens the AddDrivers frame
        JMenuItem addDriversMenuItem = findMenuItemByText(dashboard, "ADD DRIVERS");
        assertNotNull(addDriversMenuItem, "Add Drivers menu item should exist.");

        // Simulate the click event on Add Drivers menu item
        ActionListener[] actionListeners = addDriversMenuItem.getActionListeners();
        actionListeners[0].actionPerformed(new ActionEvent(addDriversMenuItem, ActionEvent.ACTION_PERFORMED, null));

        // Test if AddDrivers window opens
        assertTrue(isWindowOpened(AddDrivers.class), "AddDrivers window should open when ADD DRIVERS menu item is clicked.");
    }

    // Utility method to find JMenuItem by its text
    private JMenuItem findMenuItemByText(JFrame frame, String menuItemText) {
        JMenuBar menuBar = frame.getJMenuBar();
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem menuItem = menu.getItem(j);
                if (menuItem != null && menuItem.getText().equals(menuItemText)) {
                    return menuItem;
                }
            }
        }
        return null;
    }

    // Utility method to check if a window of a specific class type is opened
    private boolean isWindowOpened(Class<?> windowClass) {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (windowClass.isInstance(window)) {
                return true;
            }
        }
        return false;
    }
}

