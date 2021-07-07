package Shop.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static int productCounter = 0;
    private int id;
    private String name;
    private String category;
    private float price;
    private double actualPrice;
    private int stock=0;
    private static double profit = 1;
    private double discount;


    public Product(String name, float price, String category, int id  ) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = id;

    }

    @Override
    public String toString() {

        return ("ID:"+id+" Name:"+name+" Category:"+ category);
    }

    public static void setProductCounter(int productCounter) {
        Product.productCounter = productCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        Product.profit = profit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        actualPrice = price-(price*discount/100);
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}