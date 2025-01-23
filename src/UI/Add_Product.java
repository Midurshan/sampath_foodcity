/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Code.Total_Calculation;
import Code.product;
import db.database;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

public class Add_Product extends javax.swing.JFrame {

    /**
     * Creates new form Add_Product
     */
    public Add_Product() {
        initComponents();
        displayProductTable();
    }

    public void displayProductTable() {
        // List to store Product objects
        List<product> productList = new ArrayList<>();

        // Database query
        String query = "SELECT customer_id, product_id, product_name, quantity, price_per_unit, date, total_price, region FROM product";

        try (Connection con = database.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            // Populate the Product list
            while (rs.next()) {
                product p = new product();
                p.setCutomerid(rs.getInt("customer_id"));
                p.setProductid(rs.getInt("product_id"));
                p.setProductname(rs.getString("product_name"));
                p.setQty(rs.getInt("quantity"));
                p.setPriceperunit(rs.getDouble("price_per_unit"));
                p.setTotal(rs.getDouble("total_price"));
                p.setRegion(rs.getString("region"));
                productList.add(p);
                
                // Get the date from the database and set it
            Date date = rs.getDate("date"); // Assuming date is of type DATE in database
            p.setDate(date); // Set the date in the Product object

            productList.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Print full stack trace for debugging
        }

        // Convert the Product list to a 2D array
        Object[][] dataArray = new Object[productList.size()][8];
        for (int i = 0; i < productList.size(); i++) {
            product p = productList.get(i);
            dataArray[i][0] = p.getCutomerid();
            dataArray[i][1] = p.getProductid();
            dataArray[i][2] = p.getProductname();
            dataArray[i][3] = p.getQty();
            dataArray[i][4] = p.getPriceperunit();
            dataArray[i][5] = p.getDate(); // Include the `date` field
            dataArray[i][6] = p.getTotal();
            dataArray[i][7] = p.getRegion();
        }

        // Column names for JTable
        String[] columns = {"Customer ID", "Product ID", "Product Name", "Quantity", "price per unit ", "Date", "Total Price", "Region"};

        // Update the jTable1 with the data
        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(dataArray, columns);
        jTable1.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtcustomerid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtproductid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtpriceperunit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtregion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtqty = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imeges/SS logo.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel6.setText("FOOD CITY");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 20)); // NOI18N
        jLabel2.setText("SAMPATH");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Add Product");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 617, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Best Selling Product");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 171, 41));

        jButton4.setText("Branch Performance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 40));

        jButton5.setText("Customer Behavior");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 40));

        jButton6.setText("Create New User");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 170, 40));

        jButton7.setText("Product Performance");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 170, 40));

        jButton8.setText("Sales");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 170, 40));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("<  Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 230, 470));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Product ID", "Product name", "Quantity", "Price per unit", "Date", "Total price", "Region"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 710, 210));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setText("Insert");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Customer ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        txtcustomerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomeridActionPerformed(evt);
            }
        });
        jPanel1.add(txtcustomerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Product name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        txtproductname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtproductname, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 130, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Product ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));
        jPanel1.add(txtproductid, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 130, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Price per unit");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        txtpriceperunit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceperunitActionPerformed(evt);
            }
        });
        jPanel1.add(txtpriceperunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 110, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setText("Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));
        jPanel1.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("Total Price");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 130, -1));

        txtregion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregionActionPerformed(evt);
            }
        });
        jPanel1.add(txtregion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setText("Region");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 60, -1));
        jPanel1.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Customer_Behavior customer_behavior = new Customer_Behavior();
        this.dispose();
        customer_behavior.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Admin_Dashboard admin_dashboard = new Admin_Dashboard();
        this.dispose();
        admin_dashboard.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
    // Get inputs from text fields
    String customerId = txtcustomerid.getText();
    String productId = txtproductid.getText();
    String productName = txtproductname.getText();
    String unitPrice = txtpriceperunit.getText();
    String region = txtregion.getText();
    String qty = txtqty .getValue().toString();

    // Convert quantity and unit price to numbers
    int quantity = Integer.parseInt(qty);
    float unitPriceValue = Float.parseFloat(unitPrice);

    // Calculate total price
    Total_Calculation calculator = new Total_Calculation();
    double totalPrice = calculator.total_cal(quantity, unitPriceValue);

    // Display the calculated total price in txt_total_price
    txttotal.setText(String.format("%.2f", totalPrice));

    // Validate and convert date
    java.util.Date utilDate = datechooser.getDate();
    if (utilDate == null) {
        JOptionPane.showMessageDialog(null, "Please select a valid date.");
        return;
    }
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    // Establish connection to the database
    Connection con = database.getConnection();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
        return;
    }

    // Prepare SQL query
    String query = "UPDATE product SET product_id=?, product_name=?, quantity=?, price_per_unit=?, date=?, total_price=?, region=? WHERE customer_id=?";
    PreparedStatement pst = con.prepareStatement(query);

    // Set values
    pst.setInt(1, Integer.parseInt(productId));
    pst.setString(2, productName);
    pst.setInt(3, quantity);
    pst.setFloat(4, unitPriceValue);
    pst.setDate(5, sqlDate);
    pst.setDouble(6, totalPrice);
    pst.setString(7, region);
    pst.setInt(8, Integer.parseInt(customerId));

    // Execute update
    pst.executeUpdate();
    JOptionPane.showMessageDialog(null, "Product Successfully Updated");

    // Refresh the table
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    displayProductTable();

    // Clear the form fields
    txtcustomerid.setText("");
    txtproductid.setText("");
    txtproductname.setText("");
    txtqty.setValue(0);
    txtpriceperunit.setText("");
    txtregion.setText("");
    txttotal.setText("");
    datechooser.setDate(null);

    // Close resources
    pst.close();
    con.close();

} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "An error occurred while updating the product. Please try again.");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtproductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductnameActionPerformed

    private void txtpriceperunitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceperunitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceperunitActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtregionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Best_Selling_Product best_selling_product = new Best_Selling_Product();
        this.dispose();
        best_selling_product.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Branch_Performance branch_performance = new Branch_Performance();
        this.dispose();
        branch_performance.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Create_New_User create_new_user = new Create_New_User();
        this.dispose();
        create_new_user.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Product_Performance product_performance = new Product_Performance();
        this.dispose();
        product_performance.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Sales sales = new Sales();
        this.dispose();
        sales.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int customerId = Integer.parseInt(txtcustomerid.getText());
        int productId = Integer.parseInt(txtproductid.getText());
        String productName = txtproductname.getText();
        int quantity = (int) txtqty.getValue(); // Assuming dp_quantity is a JSpinner
        double pricePerUnit = Double.parseDouble(txtpriceperunit.getText());
        String region = txtregion.getText();
        java.util.Date selectedDate = datechooser.getDate();

// Add_product instance
        Add_Product p = new Add_Product();

// Assuming DefaultTableModel is already set up for the JTable "item_details"
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

// Call the insertRecord method, passing txt_total_price as a parameter
        p.insertRecord(customerId, productId, productName, quantity, pricePerUnit, region, selectedDate, model, txttotal);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtcustomeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomeridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustomeridActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Table row clicked
// Get the table model and selected row
DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
int selectedIndex = jTable1.getSelectedRow();

// Check if a valid row is selected
if (selectedIndex != -1) {
    // Set the values in the text fields from the selected row
    txtcustomerid.setText(df.getValueAt(selectedIndex, 0).toString()); // Customer ID
    txtproductid.setText(df.getValueAt(selectedIndex, 1).toString()); // Product ID
    txtproductname.setText(df.getValueAt(selectedIndex, 2).toString()); // Product Name
    txtqty.setValue(Integer.parseInt(df.getValueAt(selectedIndex, 3).toString())); // Quantity
    txtpriceperunit.setText(df.getValueAt(selectedIndex, 4).toString()); // Price per unit

    // Handle the date field (column 5)
    Object dateObj = df.getValueAt(selectedIndex, 5);
    if (dateObj != null) {
        if (dateObj instanceof java.sql.Date) {
            java.sql.Date sqlDate = (java.sql.Date) dateObj;
            datechooser.setDate(new java.util.Date(sqlDate.getTime()));
        } else if (dateObj instanceof String) {
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = sdf.parse(dateObj.toString());
                datechooser.setDate(parsedDate);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Error parsing date: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unexpected date format.");
        }
    } else {
        datechooser.setDate(null); // Clear the date picker if the date is null
    }

    txttotal.setText(df.getValueAt(selectedIndex, 6).toString()); // Total Price
    txtregion.setText(df.getValueAt(selectedIndex, 7).toString()); // Region
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // Get the selected row
            int selectedRow = jTable1.getSelectedRow(); // Replace 'tblProducts' with your JTable variable name
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                return;
            }

            // Get the primary key or unique identifier (e.g., customer_id or product_id)
            String customerID = jTable1.getValueAt(selectedRow, 0).toString(); // Column 0 as example
            String productID = jTable1.getValueAt(selectedRow, 1).toString(); // Column 1 as example

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            // Delete from database
            String query = "DELETE FROM product WHERE customer_id = ? AND product_id = ?"; // Update table and column names
            Connection con = database.getConnection(); // Ensure this method works correctly in your database class
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, customerID);
            pst.setString(2, productID);
            pst.executeUpdate();

            // Remove row from JTable
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);

            // Success message
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");

            // Close connections
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void insertRecord(int customerId, int productId, String productName, int quantity,
            double pricePerUnit, String branch, java.util.Date selectedDate,
            DefaultTableModel model, JTextField txtTotalPrice) {
        // Validate inputs
        try {
            // Calculate total price using the total_calculation class
            Total_Calculation calc = new Total_Calculation();
            double totalPrice = calc.total_cal(quantity, pricePerUnit);

            // Set the calculated total price in the txt_total_price field
            txtTotalPrice.setText(String.valueOf(totalPrice)); // Update the text field with the calculated total price

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

            // SQL query for insertion
            String query = "INSERT INTO product (customer_id, product_id, product_name, quantity, price_per_unit, region, date, total_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Execute the query
            try (Connection con = database.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, customerId);
                pstmt.setInt(2, productId);
                pstmt.setString(3, productName);
                pstmt.setInt(4, quantity);
                pstmt.setDouble(5, pricePerUnit);
                pstmt.setString(6, branch);
                pstmt.setDate(7, sqlDate);
                pstmt.setDouble(8, totalPrice);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Record successfully added!");

                    // Add the new record to the JTable
                    model.addRow(new Object[]{
                        customerId, // customer_id
                        productId, // product_id
                        productName, // product_name
                        quantity, // quantity
                        pricePerUnit,// price_per_unit
                        sqlDate, // date (java.sql.Date to match the table column type)
                        totalPrice, // total_price (calculated automatically)
                        branch // region
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "No record was inserted.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcustomerid;
    private javax.swing.JTextField txtpriceperunit;
    private javax.swing.JTextField txtproductid;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JSpinner txtqty;
    private javax.swing.JTextField txtregion;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
