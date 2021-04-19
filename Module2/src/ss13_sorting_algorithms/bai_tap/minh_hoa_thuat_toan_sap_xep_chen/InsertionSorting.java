package ss13_sorting_algorithms.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Scanner;

public class InsertionSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of elements:");
        int numberElements = scanner.nextInt();
        int[] array = new int[numberElements];
        for (int i = 0; i<numberElements; i++) {
            System.out.println("Please input element " + (i+1) + ":");
            array[i] = scanner.nextInt();
        }
        System.out.println("Your array is: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        int postion;
        int temp;
        for (int  i = 1; i < array.length; i++) {
            temp = array[i];
            postion = i;
            while (postion > 0 && temp < array[postion-1]) {
                System.out.println("Swapping element " + array[postion] + " with element " + array[postion-1]);
                array[postion] = array[postion-1];
                postion--;
            }
            array[postion] = temp;
        }
        System.out.println("Your sorted array is: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
