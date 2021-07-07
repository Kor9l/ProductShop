import entity.Product;
import services.ProductService;

import java.util.Scanner;

public class Menu {
    private ProductService productService = new ProductService;
    public void menu() {
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        while (!exit) {
            int sw = Integer.parseInt(scan.nextLine());
            switch (sw){
                case 1:
                    productService.addProduct();


            }
        }
    }
}
