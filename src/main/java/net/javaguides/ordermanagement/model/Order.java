package net.javaguides.ordermanagement.model;

public class Order {
    private int id;
    private String itemName;

    public Order(String itemName, double price, int qty, double subTotal, double grandTotal) {
        this.itemName = itemName;
        this.price = price;
        this.qty = qty;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;
    }

    public Order(int id, String itemName, double price, int qty, double subTotal, double grandTotal) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.qty = qty;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;
    }

    private double price;
    private int qty;
    private double subTotal;
    private double grandTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
