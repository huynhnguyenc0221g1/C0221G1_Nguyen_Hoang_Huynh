package ss11_map_tree.bai_tap.luyen_tap_arraylist_linkedlist.arraylist;

import java.util.*;

public class ProductManager {
    static List<Product> productList = new ArrayList<>();

    public static void addNewProduct(Product product) {
        productList.add(product);
    }

    public static void editById(int id, String name, int price) {
        int count = 0;
        int listSize = productList.size();
        for (int i = 0; i < listSize; i++) {
            boolean equalsID = id == productList.get(i).getId();
            if (equalsID) {
                count++;
                productList.get(i).setName(name);
                productList.get(i).setPrice(price);
            }
        }
        if (count == 0) {
            System.out.println("Couldn't found the ID " + id + " in your product list!");
        }
    }

    public static void removeById(int id) {
        int count = 0;
        int listSize = productList.size();
        int removedIndex = 0;
        for (int i = 0; i < listSize; i++) {
            boolean equalsID = id == productList.get(i).getId();
            if (equalsID) {
                count++;
                removedIndex = i;
            }
        }
        if (count == 0) {
            System.out.println("Couldn't found the ID " + id + " in your product list!");
        } else {
            productList.remove(removedIndex);
        }
    }

    public static void showListProduct() {
        System.out.println(productList);
    }

    public static void searchByName(String name) {
        int count = 0;
        int index = 0;
        int price = 0;
        int listSize = productList.size();
        for (int i = 0; i < listSize; i++) {
            boolean equalsName = name.equals(productList.get(i).getName());
            if (equalsName) {
                count++;
                index = productList.get(i).getId();
                price = productList.get(i).getPrice();
            }
        }
        if (count == 0) {
            System.out.println("Couldn't found the product " + name + " in your product list!");
        } else {
            System.out.println("The product " + name + " is at ID = " + index + " with the price of " + price);
        }
    }

    public static class PriceComparatorAscending implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() == o2.getPrice()) {
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
            } else if (o1.getPrice() == o2.getPrice()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
