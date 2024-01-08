package dao;

import dto.Order;

import java.util.ArrayList;
import java.util.List;

public interface Service {

    List displayAllProduct();

    int removeProduct(int pId);

    int updateProduct(String pName, double pPrice, int pQty);

    boolean placeOrder(Order ord);
}
