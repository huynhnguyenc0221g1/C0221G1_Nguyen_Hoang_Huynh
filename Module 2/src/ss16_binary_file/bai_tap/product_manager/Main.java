package ss16_binary_file.bai_tap.product_manager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean check = false;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("Menu:\n" +
                            "1.Add a product\n" +
                            "2.Show products list\n" +
                            "3.Sort products list\n" +
                            "4.Search for a product\n" +
                            "0.Exit.");
                    System.out.println("Your choice:");
                    choice = Integer.parseInt(input.nextLine());
                    if (choice < 0 || choice > 4) {
                        System.out.println("Please choose option between 1 and 4");
                    } else {
                        switch (choice) {
                            case 0:
                                System.out.println("Goodbye!");
                                check = true;
                                break;
                            case 1:
                                ProductManager.addProduct();
                                break;
                            case 2:
                                ProductManager.showProduct();
                                break;
                            case 3:
                                ProductManager.priceComparator();
                                break;
                            case 4:
                                ProductManager.search();
                                break;
                        }
                    }
                } while (choice != 0);
            }
            catch (NumberFormatException e) {
                System.out.println("Must input an integer");
            }
            catch (InputMismatchException e) {
                System.out.println("Not valid");
            }
            if(check) {
                break;
            }
        }
    }
}
