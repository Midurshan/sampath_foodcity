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
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author DELL
 */
public class Best_Selling_ProductTest {
    private Best_Selling_Product bestproduct;
    private JDateChooser sdate;
    private JTable btable;

    public Best_Selling_ProductTest() {
    }
    
    @Before
    public void setUp() {
        bestproduct = new Best_Selling_Product(); // Initialize the test class
        sdate = new JDateChooser(); // Date chooser for input
        btable = new JTable(); // Table to display results
    }

    
    @After
    public void tearDown() {
        bestproduct = null;
        sdate = null;
        btable = null;
    }



    /**
     * Test of bestproduct method, of class Best_Selling_Product.
     */
    @Test
    public void testBestproduct() {
    }

    /**
     * Test of main method, of class Best_Selling_Product.
     */
    @Test
    public void testMain() {
    }
    
    @Test
    public void testValidDate() throws SQLException {
        // Set a valid date that exists in the database
        sdate.setDate(Date.valueOf("2022-12-31"));

        bestproduct.bestproduct(sdate, btable);

        DefaultTableModel model = (DefaultTableModel) btable.getModel();

        // Assert that the table contains rows (at least one product)
        assertTrue("The table should contain at least one row for a valid date", model.getRowCount() > 0);
    }

    @Test
    public void testInvalidDate() throws SQLException {
        // Set an invalid date that does not exist in the database
        sdate.setDate(Date.valueOf("2099-01-01"));

        bestproduct.bestproduct(sdate, btable);

        DefaultTableModel model = (DefaultTableModel) btable.getModel();

        // Assert that the table is empty for an invalid date
        assertEquals("The table should be empty for an invalid date", 0, model.getRowCount());
    }

    @Test
    public void testEmptyDate() throws SQLException {
        // Set the date to null (empty input case)
        sdate.setDate(null);

        bestproduct.bestproduct(sdate, btable);

        DefaultTableModel model = (DefaultTableModel) btable.getModel();

        // Assert that the table is empty when no date is selected
        assertEquals("The table should be empty when no date is selected", 0, model.getRowCount());
    }

}
