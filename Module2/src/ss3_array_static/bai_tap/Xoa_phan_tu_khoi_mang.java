package ss3_array_static.bai_tap;

import java.util.Scanner;

public class Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        int[] array = {2, 3, 6, 21, 6, 88, 2, 9, 1917, 2021};
        System.out.println("Original Array: ");
        for (int ogIndex = 0; ogIndex < array.length; ogIndex++) {
            System.out.print(array[ogIndex] + " ");
        }
        System.out.println();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please input the index of the element you want to delete:");
            choice = input.nextInt();
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
        System.out.println("New Array: ");
        for (int newIndex = 0; newIndex < array.length; newIndex++) {
            System.out.print(array[newIndex] + " ");
        }
    }
}
