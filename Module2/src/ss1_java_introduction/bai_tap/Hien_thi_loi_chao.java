package ss1_java_introduction.bai_tap;

import java.util.Scanner;

public class Hien_thi_loi_chao {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        String name;
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
