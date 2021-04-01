package ss3_array_static.bai_tap;

import java.util.Scanner;

public class Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creating original Array
        int length;
        System.out.println("Input the length of your array:");
        length = scanner.nextInt();
        int[] array = new int[length];
        for (int index = 0; index < array.length; index++) {
            System.out.println("Input element [" + index + "] of your array:");
            array[index] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Your array is: ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
        //Deleting element at given index
        int choice;
        do {
            System.out.println("Please input the index of the element you want to delete:");
            choice = scanner.nextInt();
            if ((choice < 0) || (choice > array.length)) {
                System.out.println("Invalid index!");
            } else {
                break;
            }
        } while (choice > array.length || choice < 0);
        for (int i = choice; i < array.length; i++) {
            if (i == (array.length - 1)) {
                array[i] = 0;
            } else {
                array[i] = array[i + 1];
            }
        }
        //Printing the result
        System.out.println("New Array: ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
    }
}
