/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class product {
    private int cutomerid;
    private int productid;
    private String productname;
    private int quantity;
    private double priceperunit;
    private double total;
    private String region;
    private Date date;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCutomerid() {
        return cutomerid;
    }

    public void setCutomerid(int cutomerid) {
        this.cutomerid = cutomerid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQty() {
        return quantity;
    }

    public void setQty(int qty) {
        this.quantity = qty;
    }

    public double getPriceperunit() {
        return priceperunit;
    }

    public void setPriceperunit(double priceperunit) {
        this.priceperunit = priceperunit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
