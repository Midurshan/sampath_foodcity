/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class Login_PageTest {
    
 private Login_Page Login;  // Corrected to use 'Login' instance instead of 'login'

    public Login_PageTest() {
    }

    @Before
    public void setUp() {
        Login = new Login_Page();  // Initialize the login object that contains the login method
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class login.
     */
    
    @Test
    public void testAdminLogin() throws SQLException {
        // Assuming you already have a user "admin1" with password "admin@1" and userType "admin" in your database
        
        String result = Login.login("joe@gmail.com", "123456", "admin");  // Use the instance 'Login'
        
        // Assert that the login returns "success" for valid credentials
        assertEquals("success", result);
    }
    

    @Test
    public void testInvalidLogin() throws SQLException {
        // Simulating incorrect login credentials
        String result = Login.login("wrongUser", "wrongPassword", "admin");
        
        // Assert that the result is "invalid credentials" because the credentials are wrong
        assertEquals("invalid credentials", result);
    }
    

    @Test
    public void testEmptyFields() throws SQLException {
        // Simulating an empty username and password
        String result = Login.login("", "", "");
        
        // Assert that the result is "empty fields" because we have empty input
        assertEquals("empty fields", result);
    }
    
    @Test
    public void testEmployeeLogin() throws SQLException {
    // Assuming you have an "employee1" with password "emp@1" and userType "employee" in the database
    
    String result = Login.login("ravi12@gmail.com", "ravi123", "Employee");
    
    // Assert that the login for employee returns "success"
    assertEquals("success", result);
}
  
}
