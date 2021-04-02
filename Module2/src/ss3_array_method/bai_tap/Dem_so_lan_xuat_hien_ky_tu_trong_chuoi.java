package ss3_array_method.bai_tap;

import java.util.Scanner;

public class Dem_so_lan_xuat_hien_ky_tu_trong_chuoi {

    public static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i) || c == Character.toLowerCase(str.charAt(i)) || c == Character.toUpperCase(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        System.out.println("Please input a string: ");
        inputString = scanner.nextLine();
        System.out.println("Please input a character: ");
        char c = scanner.next(".").charAt(0);
        int result = countChar(inputString, c);
        if (result == 0) {
            System.out.println("There is no character " + c + " in the string!");
        } else if (result == 1) {
            System.out.println("Character " + c + " appears 1 time in the string!");
        } else {
            System.out.println("Character " + c + " appears " + result + " times in the string!");
        }
    }
}
