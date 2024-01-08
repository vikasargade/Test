package mainApp;

import dao.Service;
import dao.ServiceImple;
import dto.Order;
import dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static Service service = new ServiceImple();
    public static void main(String[] args) {

        System.out.println("ENTER YOUR CHOCIE: ");
        System.out.println("1.DISPLAY ALL PRODUCTS");
        System.out.println("2.REMOVE PRODUCT");
        System.out.println("3.UPDATE PRODUCT");
        System.out.println("4.PLACE ORDER");
        System.out.println("5.DISPLAY ALL ORDERS");
        System.out.println("6.EXIT");
        int ch = sc.nextInt();

        switch (ch)
        {
            case 1:
                displayAllProduct();
                break;
            case 2:
                 removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                 placeOrder();
                break;
            case 5:
                //displayAllOrders();
                break;
            case 6:
                System.out.println("APPLICATION CLOSED");
                System.exit(0);

            default:
                System.out.println("INVALID CHOCIE");
        }
        main(args);

    }

    private static void placeOrder() {
        Order ord  = new Order();

        do{
            System.out.println("ENTER PRODUCT NAME: ");
            String proudctName = sc.nextLine();
            proudctName = sc.nextLine();
            System.out.println("EMTER ORDER QUANTITY: ");
            int orderQty = sc.nextInt();

            Product product = new Product(proudctName,orderQty);
            ord.addProduct(product);

            System.out.println("DO YOU WANT TO ADD MORE PRODUCT (Y/N)");
            char ch = sc.next().charAt(0);

            if(ch=='n' || ch=='N')
            {
                break;
            }
        }while (true);

        boolean status = false;
        status = service.placeOrder(ord);

        if(status)
            System.out.println("ORDER PLACED !!");
        else
            System.out.println("ORDER NOT PLACED !!");

    }

    private static void displayAllOrders() {


    }

    private static void updateProduct() {

        System.out.println("ENTRE PRODUCT NAME");
        String pName = sc.nextLine();
        pName = sc.nextLine();
        System.out.println("ENTER NEW QUANTITY OF "+pName.toUpperCase());
        int pQty = sc.nextInt();
        System.out.println("ENTER NEW PRICE OF "+pName.toUpperCase());
        double pPrice = sc.nextDouble();

        int n = service.updateProduct(pName,pPrice,pQty);
        System.out.println("--------------------------------------------------------------");
        if(n==1)
            System.out.println(n+" PRODUCT UPDATED SUCCESSFULLY");
        else
            System.out.println("PRODUCT NOT UPDATED");
    }

    private static void removeProduct() {

        System.out.println("ENTER PRODUCT ID: ");
        int pId =sc.nextInt();

        int n =service.removeProduct(pId);
        System.out.println("---------------------------------");
        if(n==1)
            System.out.println("PRODUCT DELETED SUCESSFULLY");
        else
            System.out.println("PRODUCT NOT DELETED");

    }

    private static void displayAllProduct() {

        List<Product> productList = service.displayAllProduct();

        for(Product p:productList)
            System.out.println(p.getpId()+" "+p.getpName()+" "+p.getpQty()+" "+p.getpPrice());

    }
}
