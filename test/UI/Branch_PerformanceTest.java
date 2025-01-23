/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UI;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class Branch_PerformanceTest {

    private Branch_Performance branchPerformance;
    private JTable performanceTable;
    private JTextField totalAmountField;
    

    @Before
    public void setUp() {
        branchPerformance = new Branch_Performance(); // Create the test object
        performanceTable = new JTable(new DefaultTableModel(
                new Object[]{"Product Name", "Customer ID", "Quantity", "Total Sales"}, 0
        ));
        totalAmountField = new JTextField(); // Create a text field for the total amount
    }

    @After
    public void tearDown() {
        branchPerformance = null;
        performanceTable = null;
        totalAmountField = null;
    }

    @Test
    public void testValidBranch() throws SQLException {
        String branchName = "Galle";

        // Call the method
        branchPerformance.branch(branchName, performanceTable, totalAmountField);

        DefaultTableModel model = (DefaultTableModel) performanceTable.getModel();

        // Verify that rows are added
        assertTrue("The table should contain rows for a valid branch", model.getRowCount() > 0);

        // Verify that the total amount field is not empty
        assertFalse("The total amount field should not be empty", totalAmountField.getText().isEmpty());
    }

    @Test
    public void testEmptyBranch() throws SQLException {
        String branchName = "";

        // Call the method
        branchPerformance.branch(branchName, performanceTable, totalAmountField);

        DefaultTableModel model = (DefaultTableModel) performanceTable.getModel();

        // Verify that no rows are added
        assertEquals("The table should be empty for an empty branch", 0, model.getRowCount());

        // Verify that the total amount field is cleared
        assertEquals("The total amount field should be empty for an empty branch", "", totalAmountField.getText());
    }

    @Test
    public void testInvalidBranch() throws SQLException {
        String branchName = "jaffna";

        // Call the method
        branchPerformance.branch(branchName, performanceTable, totalAmountField);

        DefaultTableModel model = (DefaultTableModel) performanceTable.getModel();

        // Verify that no rows are added
        assertEquals("The table should be empty for an invalid branch", 0, model.getRowCount());

        // Verify that the total amount field is empty
        assertEquals("The total amount field should be empty for an invalid branch", "", totalAmountField.getText());
    }

}
