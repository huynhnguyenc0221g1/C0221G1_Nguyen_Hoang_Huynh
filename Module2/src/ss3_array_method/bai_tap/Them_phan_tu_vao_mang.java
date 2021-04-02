package ss3_array_method.bai_tap;

import java.util.Scanner;

public class Them_phan_tu_vao_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creating original Array
        int length;
        System.out.println("Input the length of your array:");
        length = scanner.nextInt();
        int[] arrayOG = new int[length];
        for (int indexOG = 0; indexOG < arrayOG.length; indexOG++) {
            System.out.println("Input element [" + indexOG + "] of your array:");
            arrayOG[indexOG] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Your array is: ");
        for (int indexOG = 0; indexOG < arrayOG.length; indexOG++) {
            System.out.print(arrayOG[indexOG] + " ");
        }
        System.out.println();

        //Crafting New Array with the OG Array plus the added value at the specific index
        int indexAdd, valueAdd;
        int[] arrayNew = new int[length + 1];

        do {
            System.out.println("Please input the index position that you want to add new value to your array:");
            indexAdd = scanner.nextInt();
            if ((indexAdd < 0) || (indexAdd > arrayOG.length)) {
                System.out.println("Invalid index!");
            } else {
                System.out.println("Please input the value:");
                valueAdd = scanner.nextInt();
                arrayNew[indexAdd] = valueAdd;
                for (int beforeAdd = 0 ; beforeAdd < indexAdd ; beforeAdd++) {
                    arrayNew[beforeAdd] = arrayOG[beforeAdd];
                }
                for (int afterAdd = indexAdd; afterAdd < arrayOG.length ; afterAdd++) {
                    arrayNew[afterAdd+1] = arrayOG[afterAdd];
                }
                break;
            }

        } while ((indexAdd < 0) || (indexAdd > arrayOG.length));
        System.out.println("New Array is:");
        for (int indexNew = 0 ; indexNew < arrayNew.length ; indexNew++) {
            System.out.print(arrayNew[indexNew] + " ");
        }
    }
}
