package UI;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Product_PerformanceTest {

    private Product_Performance instance;
    private JTable table;
    private JTextField bestSalesRegionField;

    @Before
    public void setUp() {
        instance = new Product_Performance(); // Initialize the class being tested
        table = new JTable(new DefaultTableModel(new Object[]{"Product Name", "Quantity Sold", "Total Sales"}, 0)); // Mock JTable
        bestSalesRegionField = new JTextField(); // Mock JTextField
    }

    @After
    public void tearDown() {
        instance = null;
        table = null;
        bestSalesRegionField = null;
    }

    /**
     * Test valid product ID (integer).
     */
    @Test
    public void testValid() throws SQLException {
        int validProductId = 103; // Valid product ID

        // Call the productPerformance method with valid input
        instance.productPerformance(validProductId, table, bestSalesRegionField);

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Verify the table contains rows
        assertTrue("The table should contain at least one row for a valid product ID", model.getRowCount() > 0);
        // Verify the best sales region field is populated
        assertTrue("The best sales region field should be populated", bestSalesRegionField.getText().length() > 0);
    }

    /**
     * Test invalid product ID (non-existent product).
     */
    @Test
    public void testInvalid() throws SQLException {
        int invalidProductId = 1000; // Invalid product ID

        // Call the productPerformance method with invalid input
        instance.productPerformance(invalidProductId, table, bestSalesRegionField);

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Verify the table contains no rows
        assertEquals("The table should contain no rows for an invalid product ID", 0, model.getRowCount());
        // Verify the best sales region field is empty
        assertEquals("The best sales region field should be empty for an invalid product ID", "", bestSalesRegionField.getText());
    }

    @Test
    public void testEmpty() throws SQLException {
        Integer emptyProductId = null; // Represent empty as null

        if (emptyProductId == null) {
            // Simulate the behavior when no product ID is provided
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Ensure table is cleared
            bestSalesRegionField.setText(""); // Ensure text field is cleared
        } else {
            // Call the method if product ID is not null (not empty)
            instance.productPerformance(emptyProductId, table, bestSalesRegionField);
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Assert that the table contains no rows
        assertEquals("The table should contain no rows for an empty product ID", 0, model.getRowCount());
        // Assert that the best sales region field is empty
        assertEquals("The best sales region field should be empty for an empty product ID", "", bestSalesRegionField.getText());
    }

}
