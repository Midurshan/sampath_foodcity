package UI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class Daily_SalesTest {

    private Daily_Sales dailySales;
    private JDateChooser sdate;
    private JTable salesTable;
    private JTextField dailySalesTextField;

    @Before
    public void setUp() {
        dailySales = new Daily_Sales(); // Instantiate the class to be tested
        sdate = new JDateChooser(); // Create a date chooser
        salesTable = new JTable(); // Create a table for sales
        dailySalesTextField = new JTextField(); // Create a text field for total sales
    }

    @After
    public void tearDown() {
        dailySales = null;
        sdate = null;
        salesTable = null;
        dailySalesTextField = null;
    }

    /**
     * Test for a valid date with data in the database.
     */
    @Test
    public void testValidDate() throws SQLException {
        // Set a valid date (ensure this date exists in the database and has sales data)
        sdate.setDate(Date.valueOf("2022-12-31"));

        // Call the method
        dailySales.daily(sdate, salesTable, dailySalesTextField);

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Validate the results
        assertTrue("The table should have at least one row for a valid date.", model.getRowCount() > 0);
        assertNotNull("The daily sales text field should not be null for a valid date.", dailySalesTextField.getText());
        assertFalse("The daily sales text field should not be empty for a valid date.", dailySalesTextField.getText().isEmpty());
    }

    
    @Test
    public void testInvalidDate() throws SQLException {
        // Set an invalid date (ensure this date does not exist in the database)
        sdate.setDate(Date.valueOf("2099-12-31"));

        // Call the method
        dailySales.daily(sdate, salesTable, dailySalesTextField);

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Validate the results
        assertEquals("The table should be empty for an invalid date.", 0, model.getRowCount());
        assertTrue("The daily sales text field should be empty for an invalid date.", dailySalesTextField.getText().isEmpty());
    }

    /**
     * Test for an empty date (null date).
     */
    @Test
    public void testEmptyDate() throws SQLException {
        // Set the date chooser to null
        sdate.setDate(null);

        // Call the method
        dailySales.daily(sdate, salesTable, dailySalesTextField);

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();

        // Validate the results
        assertEquals("The table should be empty when no date is selected.", 0, model.getRowCount());
        assertTrue("The daily sales text field should be empty when no date is selected.", dailySalesTextField.getText().isEmpty());
    }
}
