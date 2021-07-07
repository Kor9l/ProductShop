package Shop.services;
import Shop.entity.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public  class ProductService {

    private static ArrayList<Product> products;
    private static int idCounter =0;

    //Initialize
    public static void initialize(){
        products = new ArrayList<Product>();
        products.add( new Product("Vafel",50,"Food",++idCounter));
        products.add( new Product("Bread",30,"Food",++idCounter));
        products.add( new Product("Apple",5,"Food",++idCounter));
        products.add( new Product("Coke",25,"Drinks",++idCounter));
        products.add( new Product("Sprite",24,"Drinks",++idCounter));

    }

    //Save
    void saveProducts() throws IOException {
        FileOutputStream fos = new FileOutputStream("products.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.close();
    }

    //Get product NAme by ID
    public static   String getProductNamebyID( ){
        System.out.print("Enter product ID:");
        int id = scanInt();
        for (Product prod:products){
            if (prod.getId()==id){
                return prod.getName();
            }
        }
        return "No such ID";
    }

    //Delete product
    public static void deleteProduct( ){
        System.out.print("Enter ID to delete:");
        int id = scanInt();
        products.removeIf(prod -> prod.getId() == id);

    }

    //Add product
    public static void addProduct( ){

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

    public static void showProducts() {
        for (Product product:products) {
            System.out.println(product);
             }
    }

    //Show products in category
    public static void prodCatShow( ) {
        System.out.print("Enter category of product:");
        String cat = scanString();
        for (Product prod:products) {
            if(prod.getCategory().equals(cat)){
                System.out.println(prod);
            }

        }
    }

    //Add discount for cat
    //Show products in category
    public static void addDisProd( ) {
        System.out.print("Enter category of product:");
        String cat = scanString();
        System.out.println("Enter discount:");
        double discount = scanDouble();
        for (Product prod:products) {
            if(prod.getCategory().equals(cat)){
                prod.setDiscount(discount);
            }

        }
    }

    //Sort by name
        public static void sortByName(){
        products.sort(Comparator.comparing(Product::getName));
            showProducts();
        }
        public static void sortByPrice(){
        products.sort(Comparator.comparing(Product::getPrice));
            showProducts();
        }
        public static void sortByActPrice(){
        products.sort(Comparator.comparing(Product::getActualPrice));
            showProducts();
        }
    //Scanners
    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    public static String scanString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static double scanDouble(){
        Scanner scanner = new Scanner(System.in);
        return Double.parseDouble(scanner.nextLine());
    }



}