package ss3_array_method.bai_tap;
import java.util.Scanner;
public class Tong_1_cot_trong_ma_tran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height, width;
        //Generating a matrix with given height (length of the 2D array) and width
        System.out.println("Please input the matrix's height:");
        height = scanner.nextInt();
        System.out.println("Please input the matrix's width:");
        width = scanner.nextInt();
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("Please input element [" +i+ "]["+j+"] of the matrix:");
                matrix[i][j] = scanner.nextInt();
            }
        }
        //Printing the matrix
        System.out.println("Your matrix is:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //Generating the sum of a column of the matrix
        int col;
        System.out.println("Which column do you want to get the summary?");
        col = scanner.nextInt();
        int sum = 0;
        for (int  i = 0; i< matrix.length; i++) {
            sum += matrix[i][col-1];
        }
        System.out.println("The sumamary of column " + col + " is: " + sum);
    }
}
