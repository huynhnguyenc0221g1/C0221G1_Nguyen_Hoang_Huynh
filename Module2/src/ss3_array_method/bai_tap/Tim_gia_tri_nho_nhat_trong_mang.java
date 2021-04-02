package ss3_array_method.bai_tap;
import java.util.Scanner;
public class Tim_gia_tri_nho_nhat_trong_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creating an Array
        int length;
        System.out.println("Input the length of your array:");
        length = scanner.nextInt();
        int[] array = new int[length];
        for (int index = 0; index < array.length; index++) {
            System.out.println("Input element [" + index + "] of your array:");
            array[index] = scanner.nextInt();
        }
        //Printing the array
        System.out.println();
        System.out.println("Your array is: ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
        //Finding Min in Array
        int min = array[0];
        int minId = 0;
        for (int index = 0; index < array.length; index++) {
            if (min > array[index]) {
                min = array[index];
                minId = index;
            }
        }
        System.out.println("The minimum element of the array is " + min + " at index " + minId);
    }
}
