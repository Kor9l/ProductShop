package Shop;

import Shop.services.ProductService;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        ProductService.initialize();
        boolean cont = true;
        Scanner scan = new Scanner(System.in);
        while (cont) {
            int sw = Integer.parseInt(scan.nextLine());
            switch (sw){
                case 1:
                    ProductService.addProduct();


            }
        }
    }
}
