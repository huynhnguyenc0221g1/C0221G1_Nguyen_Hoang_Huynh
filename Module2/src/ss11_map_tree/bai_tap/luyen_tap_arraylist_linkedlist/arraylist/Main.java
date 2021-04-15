package ss11_map_tree.bai_tap.luyen_tap_arraylist_linkedlist.arraylist;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please choose 1 option!");
            System.out.println("1. Add a new product");
            System.out.println("2. Edit a product by ID");
            System.out.println("3. Delete a product by ID");
            System.out.println("4. Show your product list");
            System.out.println("5. Search for a product by name");
            System.out.println("6. Sort your product list by price");
            System.out.println("7. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Please input the product's name:");
                    String productName = scanner.nextLine();
                    System.out.println("Please input the product's ID:");
                    int productID = scanner.nextInt();
                    System.out.println("Please input the product's price:");
                    int productPrice = scanner.nextInt();
                    Product product = new Product(productName, productID, productPrice);
                    ProductManager.addNewProduct(product);
                    break;
                case 2:
                    System.out.println("Please input an ID:");
                    int editID = scanner.nextInt();
                    System.out.println("Enter product's new name:");
                    String editName = scanner.next();
                    System.out.println("Enter product's new price");
                    int editPrice = scanner.nextInt();
                    ProductManager.editById(editID, editName, editPrice);
                    break;
                case 3:
                    System.out.println("Please input an ID:");
                    int removeID = scanner.nextInt();
                    ProductManager.removeById(removeID);
                    break;
                case 4:
                    ProductManager.showListProduct();
                    break;
                case 5:
                    System.out.println("Please input a product's name:");
                    String searchName = scanner.nextLine();
                    System.out.println(searchName);
                    ProductManager.searchByName(searchName);
                    break;
                case 6:
                    ProductManager.PriceComparatorAscending priceComparatorAscending = new ProductManager.PriceComparatorAscending();
                    ProductManager.PriceComparatorDescending priceComparatorDescending = new ProductManager.PriceComparatorDescending();
                    System.out.println("Please choose a sorting method:");
                    System.out.println("1. Ascending Order");
                    System.out.println("2. Descending Order");
                    byte sortChoice = scanner.nextByte();
                    if (sortChoice == 1) {
                        Collections.sort(ProductManager.productList, priceComparatorAscending);
                    } else if (sortChoice == 2) {
                        Collections.sort(ProductManager.productList, priceComparatorDescending);
                    } else {
                        System.out.println("Must choose 1 or 2!");
                    }
                    ProductManager.showListProduct();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 7);

    }
}
