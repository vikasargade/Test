package dao;

import dto.Order;
import dto.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImple implements  Service{

    static Connection conn;
    static {
        String url ="jdbc:mysql://localhost:3306/testdb";
        String uName="root";
        String uPass="tiger";

        try {
            conn = DriverManager.getConnection(url,uName,uPass);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public List displayAllProduct() {

        List<Product> pList = new ArrayList<>();
        String query = "select * from product_info";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Product product =new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                pList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pList;
    }

    @Override
    public int removeProduct(int pId) {

        String deleteQuery = "DELETE FROM product_info WHERE p_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1 ,pId);
            return  pstmt.executeUpdate() ;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    @Override
    public int updateProduct(String pName, double pPrice, int pQty) {


        String updateQuery = "UPDATE PRODUCT_INFO SET p_price = "+pPrice+" , p_qty="+pQty+" WHERE p_name = '"+pName+"'";
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(updateQuery);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public boolean placeOrder(Order ord) {
            String placeOrderProcedure = "{call placeOrder(?,?,?)}";

            try {
                CallableStatement cstmt = conn.prepareCall(placeOrderProcedure);


                    cstmt.setInt(1, ord.getOrderId());
                    cstmt.setString(2, ord.getProductName());
                    cstmt.setInt(3 , ord.getProductQty());
                    cstmt.execute();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return  true;

    }
}
