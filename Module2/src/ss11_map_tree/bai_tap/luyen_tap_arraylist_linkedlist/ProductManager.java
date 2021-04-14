package ss11_map_tree.bai_tap.luyen_tap_arraylist_linkedlist;

import java.util.*;

public class ProductManager {
    static List<Product> productList = new ArrayList<>();
    static int listSize = productList.size();
    public static void addNewProduct(Product product) {
        productList.add(product);
    }

    public static void showListProduct() {
        System.out.println(productList);
    }

    public static void editById(int id, String name, int price) {
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                count++;
                productList.get(i).setName(name);
                productList.get(i).setPrice(price);
            }
        }
        if (count==0) {
            System.out.println("Couldn't found the ID " + id + " in your product list!");
        }
    }
    public static void removeById(int id) {
        int count = 0;
        for (int i = 0; i <= listSize; i++) {
            if (id == productList.get(i).getId()) {
                count++;
                productList.remove(i);
            }
        }
        if (count==0) {
            System.out.println("Couldn't found the ID " + id + " in your product list!");
        }
    }
    public static void searchByName(String name) {
        int count = 0;
        int index = 0;
        int price = 0;
        System.out.println(name);
        System.out.println(name.equals(productList.get(0).getName()));
        for (int i = 0; i < listSize; i++) {
            if (name.equals(productList.get(i).getName())) {
                count++;
                index = productList.get(i).getId();
                price = productList.get(i).getPrice();
                System.out.println(productList.get(i).getName());
                System.out.println(name.equals(productList.get(i).getName()));
            }
        }
        System.out.println(count);
//        if (count!=0) {
//            System.out.println("Your product " + name + " is in the products list by ID = " + index
//                    + " and the price of " + price);
//        } else {
//            System.out.println("Couldn't found the product " + name + " in your product list!");
//        }
    }
    public static class PriceComparatorAscending implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            }
            else if (o1.getPrice() == o2.getPrice()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    public static class PriceComparatorDescending implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return -1;
            }
            else if (o1.getPrice() == o2.getPrice()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
