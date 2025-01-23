package UI;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class Annual_SalesTest {

    private Annual_Sales annualSales;
    private JTextField yearField;
    private JTextField annualSalesField;
    private JTable table;

    @Before
    public void setUp() {
        // Initialize the test object and GUI components
        annualSales = new Annual_Sales(); // Assuming your class is named Annual_Sales
        yearField = new JTextField(); // Year input field
        annualSalesField = new JTextField(); // Field to display the annual sales total
        table = new JTable(new DefaultTableModel(
                new Object[]{"Product Name", "Quantity", "Unit Price", "Total Sold"}, 0
        ));
    }

    @After
    public void tearDown() {
        // Clean up the resources after each test
        annualSales = null;
        yearField = null;
        annualSalesField = null;
        table = null;
    }

    @Test
    public void testValidYear() throws SQLException {
        // Test with a valid year input
        String yearInput = "2023";
        yearField.setText(yearInput); // Set the valid year in the text field

        // Call the method to fetch annual sales data
        annualSales.Annual(yearField, annualSalesField, table);

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Assert that rows are added to the table (valid data should be present)
        assertTrue("The table should contain rows for a valid year", model.getRowCount() > 0);

        // Assert that the annual sales field is not empty
        assertFalse("The annual sales field should not be empty", annualSalesField.getText().isEmpty());
    }

    @Test
    public void testEmptyYear() throws SQLException {
        // Test with an empty year input
        yearField.setText(""); // Leave the year input empty

        // Call the method to fetch annual sales data
        annualSales.Annual(yearField, annualSalesField, table);

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Assert that no rows are added to the table
        assertEquals("The table should be empty for an empty year", 0, model.getRowCount());

        // Assert that the annual sales field is empty
        assertEquals("The annual sales field should be empty for an empty year", "", annualSalesField.getText());
    }

    @Test
    public void testInvalidYear() throws SQLException {
        // Test with an invalid year input (non-numeric)
        String yearInput = "1234";
        yearField.setText(yearInput); // Set an invalid year

        // Call the method to fetch annual sales data
        annualSales.Annual(yearField, annualSalesField, table);

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Assert that no rows are added to the table
        assertEquals("The table should be empty for an invalid year", 0, model.getRowCount());

        // Assert that the annual sales field is empty
        assertEquals("The annual sales field should be empty for an invalid year", "", annualSalesField.getText());
    }

}
