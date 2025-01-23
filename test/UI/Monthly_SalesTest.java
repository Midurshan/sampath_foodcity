package UI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class Monthly_SalesTest {

    private Monthly_Sales salesReport;
    private JDateChooser date_start;
    private JDateChooser date_end;
    private JTable salesTable;
    private JTextField monthlySalesTextField;

    public Monthly_SalesTest() {
    }

    @Before
    public void setUp() {
        // Initialize your components here
        salesReport = new Monthly_Sales();
        date_start = new JDateChooser();
        date_end = new JDateChooser();
        salesTable = new JTable();
        monthlySalesTextField = new JTextField();
    }

    @After
    public void tearDown() {
        // Clean up after each test if necessary
    }

    /**
     * Test of monthly method, of class Monthly_Sales.
     */
    @Test
    public void testMonthly_ValidDateRange() throws SQLException {
        // Set valid start and end dates that exist in the database
        date_start.setDate(Date.valueOf("2023-01-01"));
        date_end.setDate(Date.valueOf("2023-01-31"));

        // Call the monthly method
        salesReport.monthly(date_start, date_end, salesTable, monthlySalesTextField);

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Assert table is populated
        assertTrue("The table should contain rows for a valid date range", model.getRowCount() > 0);

        // Assert overall total is calculated and displayed
        assertTrue("The total sales field should not be empty for valid data", !monthlySalesTextField.getText().isEmpty());
    }

    @Test
    public void testInvalidDateRange() throws SQLException {
        // Set a date range where no data exists in the database
        date_start.setDate(Date.valueOf("2099-01-01"));
        date_end.setDate(Date.valueOf("2099-01-31"));

        // Call the monthly method
        salesReport.monthly(date_start, date_end, salesTable, monthlySalesTextField);

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Assert table is empty
        assertEquals("The table should be empty for an invalid date range", 0, model.getRowCount());

        // Assert total sales field is empty
        assertEquals("The total sales field should be empty for an invalid date range", "", monthlySalesTextField.getText());
    }

    @Test
    public void testMonthly_EmptyDates() throws SQLException {
        // Set both start and end dates to null
        date_start.setDate(null);
        date_end.setDate(null);

        // Call the monthly method
        salesReport.monthly(date_start, date_end, salesTable, monthlySalesTextField);

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Assert table is empty
        assertEquals("The table should be empty when no dates are selected", 0, model.getRowCount());

        // Assert total sales field is empty
        assertEquals("The total sales field should be empty when no dates are selected", "", monthlySalesTextField.getText());
    }

   

   

    /**
     * Test of main method, of class Monthly_Sales.
     */
    @Test
    public void testMain() {
        // You can add the test for the main method here if needed.
        // Since the main method may be for starting the UI, you can test if the UI initializes properly.
    }
}
