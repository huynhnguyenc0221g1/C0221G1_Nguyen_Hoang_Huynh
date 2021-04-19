package ss13_sorting_algorithms.bai_tap.cai_dat_sap_xep_chen;
import java.util.*;
public class Main {
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
        InsertionSorting.insertionSort(array);
    }
}
