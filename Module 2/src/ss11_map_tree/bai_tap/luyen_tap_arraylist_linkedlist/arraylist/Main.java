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
                    addProduct(scanner);
                    break;
                case 2:
                    editProductById(scanner);
                    break;
                case 3:
                    removeProductById(scanner);
                    break;
                case 4:
                    showProducts();
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    sortProducts(scanner);
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 7);

    }

    private static void addProduct(Scanner scanner) {
        System.out.println("Please input the product's name:");
        String productName = scanner.nextLine();
        System.out.println("Please input the product's ID:");
        int productID = scanner.nextInt();
        System.out.println("Please input the product's price:");
        int productPrice = scanner.nextInt();
        Product product = new Product(productName, productID, productPrice);
        ProductManager.addNewProduct(product);
        return;
    }

    private static void editProductById(Scanner scanner) {
        System.out.println("Please input an ID:");
        int editID = scanner.nextInt();
        System.out.println("Enter product's new name:");
        String editName = scanner.next();
        System.out.println("Enter product's new price");
        int editPrice = scanner.nextInt();
        ProductManager.editById(editID, editName, editPrice);
    }

    private static void removeProductById(Scanner scanner) {
        System.out.println("Please input an ID:");
        int removeID = scanner.nextInt();
        ProductManager.removeById(removeID);
    }

    private static void showProducts() {
        ProductManager.showListProduct();
    }

    private static void searchProduct(Scanner scanner) {
        System.out.println("Please input a product's name:");
        String searchName = scanner.nextLine();
        System.out.println(searchName);
        ProductManager.searchByName(searchName);
    }

    private static void sortProducts(Scanner scanner) {
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
        showProducts();
    }
}
