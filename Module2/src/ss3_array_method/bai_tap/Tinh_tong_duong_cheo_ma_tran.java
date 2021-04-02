package ss3_array_method.bai_tap;
import java.util.Scanner;
public class Tinh_tong_duong_cheo_ma_tran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        //Generating a square matrix with given size (length of the 2D array)
        System.out.println("Please input the square matrix's size:");
        size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Please input element [" +i+ "]["+j+"] of the matrix:");
                matrix[i][j] = scanner.nextInt();
            }
        }
        //Printing the matrix
        System.out.println("Your matrix is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //Generating the main cross sum
        int sum = 0;
        for (int i = 0; i<size; i++) {
            sum += matrix[i][i];
        }
        System.out.println("The sum of the main cross of the square matrix is " + sum);
    }
}
