package services;
import entity.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();
    private int idCounter =0;

    //Save
    void saveProducts() throws IOException {
        FileOutputStream fos = new FileOutputStream("products.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.close();
    }

    //Get product NAme by ID
    public  String getProductID(int id){
        for (Product prod:products){
            if (prod.getId()==id){
                return prod.getName();
            }
        }
        return "No such ID";
    }

    //Delete product
    void deleteProduct(int id){
        products.removeIf(prod -> prod.getId() == id);

    }

    //Add product
    public  void addProduct( ){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter category");
        String category = scanner.nextLine();
        System.out.println("Enter price");
        float price = scanner.nextFloat();
        int id = ++idCounter;
        products.add(new Product(name,price,category,id));
    }

    //Show products

    public void showProducts() {
        for (Product product:products) {
            System.out.println(product);
             }
    }

    //Show products in category
    public void podCatShow(String cat) {
        for (Product prod:products) {
            if(prod.getCategory().equals(cat)){
                System.out.println(prod);
            }

        }
    }

    //Add discount for cat
    //Show products in category
    public void addDisProd(String cat,double discount) {
        for (Product prod:products) {
            if(prod.getCategory().equals(cat)){
                prod.setDiscount(discount);
            }

        }
    }


}