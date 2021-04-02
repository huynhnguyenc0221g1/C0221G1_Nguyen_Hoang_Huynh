package ss2_java_loop_method.bai_tap;

import java.util.Scanner;

public class Hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choice;
        String whiteSpace = " ";
        do {
            System.out.println("Please choose one option:");
            System.out.println("1. Print a rectangle");
            System.out.println("2. Print 4 square-triangles from 4 different angles");
            System.out.println("3. Print a isosceles triangle");
            System.out.println("4. Exit");
            choice = input.nextByte();
            switch (choice) {
                case 1:
                    int recWidth, recHeight;
                    System.out.println("Input rectangle width:");
                    recWidth = input.nextInt();
                    System.out.println("Input rectangle height:");
                    recHeight = input.nextInt();
                    for (int i = 0; i < recHeight; i++) {
                        for (int j = 0; j < recWidth; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int triangleHeight;
                    System.out.println("Input triangle height:");
                    triangleHeight = input.nextInt();
                    //Top-left
                    for (int iTopLeft = 0; iTopLeft < triangleHeight; iTopLeft++) {
                        for (int jTopLeft = triangleHeight - 1; jTopLeft >= iTopLeft; jTopLeft--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    //Top-right
                    for (int iTopRight = 0; iTopRight < triangleHeight; iTopRight++) {
                        for (int jTopRight = 0; jTopRight < triangleHeight; jTopRight++) {
                            if (jTopRight < iTopRight) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    //Bottom-left
                    for (int iBottomLeft = 0; iBottomLeft < triangleHeight; iBottomLeft++) {
                        for (int jBottomLeft = 0; jBottomLeft <= iBottomLeft; jBottomLeft++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    //Bottom-right
                    for (int iBottomRight = 0; iBottomRight < triangleHeight; iBottomRight++) {
                        for (int jBottomRight = 1; jBottomRight <= triangleHeight; jBottomRight++) {
                            if ((triangleHeight - jBottomRight) <= iBottomRight) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    int isoHeight;
                    System.out.println("Input triangle height:");
                    isoHeight = input.nextInt();
                    for (int iIso = 1; iIso <= isoHeight; iIso++) {
                        for (int jIso = 1; jIso <= (2 * isoHeight); jIso++) {
                            if (Math.abs(isoHeight - jIso) <= (iIso - 1)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (choice != 4);
    }
}
