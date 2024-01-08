package dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {

    private int orderId;
    private String productName;

    public String getProductName() {
        return productName;
    }

    private int ProductId;
    private int productQty;
    private double total;
    List<Product> productList = new ArrayList<>();

    public Order() {
    }

    public Order(String productName, int productId, int productQty, double total) {
        this.productName = productName;
        ProductId = productId;
        this.productQty = productQty;
        this.total = total;
    }

    public Order(String productName, int productId, int productQty) {
        this.productName = productName;
        ProductId = productId;
        this.productQty = productQty;
    }

    public Order(int orderId, String productName, int productId, int productQty, double total) {
        this.orderId = orderId;
        this.productName = productName;
        ProductId = productId;
        this.productQty = productQty;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void addProduct(Product product) {
        productList.add(product);
    }
}
