package ss03_array_method.bai_tap;

import java.util.Scanner;

public class Gia_tri_lon_nhat_cua_mang_2_chieu {
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
                System.out.println("Please input element [" + i + "][" + j + "] of the matrix:");
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
        //Finding the maximum element in the Matrix
        int max = matrix[0][0];
        int maxHeight = 0;
        int maxWidth = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    maxHeight = i;
                    maxWidth = j;
                }
            }
        }
        System.out.print("The maximum element is " + max + " at id [" + maxHeight + "][" + maxWidth + "]");
    }
}

