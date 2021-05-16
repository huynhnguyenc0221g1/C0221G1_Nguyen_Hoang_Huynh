package ss03_array_method.bai_tap;

import java.util.Scanner;

public class Gop_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1, length2, lengthFinal;
        //Creating Array 1
        System.out.println("Input the length of the first array:");
        length1 = scanner.nextInt();
        int[] arr1 = new int[length1];
        for (int i1 = 0; i1 < length1; i1++) {
            System.out.println("Input element [" + i1 + "] of the first array:");
            arr1[i1] = scanner.nextInt();
        }
        //Creating Array 2
        System.out.println("Input the length of the second array:");
        length2 = scanner.nextInt();
        int[] arr2 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            System.out.println("Input element [" + i2 + "] of the second array:");
            arr2[i2] = scanner.nextInt();
        }
        //Printing the 2 OG Arrays
        System.out.println("First array is:");
        for (int i1 = 0; i1 < length1; i1++) {
            System.out.print(arr1[i1] + " ");
        }
        System.out.println();
        System.out.println("Second array is:");
        for (int i2 = 0; i2 < length2; i2++) {
            System.out.print(arr2[i2] + " ");
        }
        System.out.println();
        //Joining the 2 OG Arrays
        lengthFinal = length1 + length2;
        int[] arrFinal = new int[lengthFinal];
        for (int i1 = 0; i1 < length1; i1++) {
            arrFinal[i1] = arr1[i1];
        }
        for (int i2 = 0; i2 < length2; i2++) {
            arrFinal[i2 + length1] = arr2[i2];
        }
        //Printing the joined Array:
        System.out.println("Joined Array is:");
        for (int iFinal = 0; iFinal < lengthFinal; iFinal++) {
            System.out.print(arrFinal[iFinal] + " ");
        }
    }
}
