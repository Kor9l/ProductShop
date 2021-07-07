package Shop;

import Shop.services.ProductService;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        ProductService.initialize();

        boolean cont = true;
        Scanner scan = new Scanner(System.in);
        while (cont) {
            showMenu();
            int sw = Integer.parseInt(scan.nextLine());
            switch (sw) {
                case 1:
                    ProductService.addProduct();
                    break;
                case 2:
                    ProductService.getProductNamebyID();
                    break;
                case 3:
                    ProductService.showProducts();
                    break;
                case 4:
                    ProductService.deleteProduct();
                    break;
                case 5:
                    ProductService.prodCatShow();
                    break;
                case 6:
                    ProductService.addDisProd();
                    break;
                case 7:
                    sortMenu();
                    sw = Integer.parseInt(scan.nextLine());
                    switch (sw) {
                        case 1:
                            ProductService.sortByName();
                            break;
                        case 2:
                            ProductService.sortByPrice();
                            break;
                        case 3:
                            ProductService.sortByActPrice();
                            break;
                    }
                    break;


                case 10:
                    cont = false;
                    break;
            }
        }

    }

    static void showMenu() {
        System.out.print("------------\n1.Add product\n" +
                "2.Get product name by ID\n" +
                "3.Get list of products\n" +
                "4.Delete product by ID\n" +
                "5.Show category of product\n" +
                "6.Add discount for category\n" +
                "7.Sorted view\n" +
                "10.Exit\n Your chose is:");
    }
    static  void sortMenu(){
        System.out.print("1.Sort by name\n2.Sort by price\n3.Sort by actual price\nYour chose is:");
    }
}
