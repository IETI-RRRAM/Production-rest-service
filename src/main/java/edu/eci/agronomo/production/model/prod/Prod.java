package edu.eci.agronomo.production.model.prod;

import java.util.Date;

public class Prod {
    private String product;
    private int quantity;
    private String measurement;
    private Date date;

    public Prod(String product, int quantity, String measurement, Date date) {
        this.product = product;
        this.quantity = quantity;
        this.measurement = measurement;
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
