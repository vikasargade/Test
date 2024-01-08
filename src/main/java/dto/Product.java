package dto;

public class Product {

    private int pId;
    private String pName;
    private int pQty;
    private double pPrice;

    public Product() {
    }

    public Product(int pId, String pName, int pQty, double pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pQty = pQty;
        this.pPrice = pPrice;
    }

    public Product(String pName, int pQty) {
        this.pName = pName;
        this.pQty = pQty;
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public int getpQty() {
        return pQty;
    }

    public void setpQty(int pQty) {
        this.pQty = pQty;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }
}
