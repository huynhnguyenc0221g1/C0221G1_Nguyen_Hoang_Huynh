package ss13_sorting_algorithms.bai_tap.cai_dat_sap_xep_chen;

public class InsertionSorting {
    public static void insertionSort(int[] array) {
        int postion;
        int temp;
        for (int  i = 1; i < array.length; i++) {
            temp = array[i];
            postion = i;
            while (postion > 0 && temp < array[postion-1]) {
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
