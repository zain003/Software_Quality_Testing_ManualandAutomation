package hotel.management.system.automatedTests;

import hotel.management.system.AddEmployee;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

import javax.swing.*;

public class AddEmployeeGUITest {

    private FrameFixture window;

    @Before
    public void setUp() {
        AddEmployee frame = new AddEmployee();
        window = new FrameFixture(frame);
        window.show(); // Show the frame to start testing
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testNameField() {
        window.textBox("nameField").enterText("John Doe");
        Assert.assertEquals("John Doe", window.textBox("nameField").text());
    }

    @Test
    public void testAgeField() {
        window.textBox("ageField").enterText("25");
        Assert.assertEquals("25", window.textBox("ageField").text());
    }

    @Test
    public void testGenderSelection() {
        // Select the male radio button
        window.radioButton("maleRadioButton").click();

        // Verify that the male radio button is selected
        Assert.assertTrue(window.radioButton("maleRadioButton").target().isSelected());
    }

    @Test
    public void testJobSelection() {
        // Select an item from the combo box
        window.comboBox("jobComboBox").selectItem("Manager");
        // Verify the selected item
        Assert.assertEquals("Manager", window.comboBox("jobComboBox").selectedItem());
    }
    @Test
    public void testSaveButton() {
        // Fill out all fields
        window.textBox("nameField").enterText("John Doe");
        window.textBox("ageField").enterText("30");
        window.radioButton("maleRadioButton").click();
        window.comboBox("jobComboBox").selectItem("Manager");
        window.textBox("salaryField").enterText("50000");
        window.textBox("phoneField").enterText("1234567890");
        window.textBox("aadharField").enterText("123456789012");
        window.textBox("emailField").enterText("john.doe@example.com");

        // Click the Save button
        window.button(JButtonMatcher.withName("saveButton")).click();

        // Add a delay to give time for the dialog to appear (optional)
        try {
            Thread.sleep(1000);  // Adjust the delay based on your system's performance
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the label in the dialog and get its text
        String dialogMessage = window.dialog().label().text();
        System.out.println("Dialog message: " + dialogMessage);

        // Assert that the dialog displays the expected message
        Assert.assertTrue(dialogMessage.contains("Employee Added Successfully"));
    }

}

