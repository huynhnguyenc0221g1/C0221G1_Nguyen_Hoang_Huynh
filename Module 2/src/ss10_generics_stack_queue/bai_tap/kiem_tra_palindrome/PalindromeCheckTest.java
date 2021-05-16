package ss10_generics_stack_queue.bai_tap.kiem_tra_palindrome;

import java.util.*;

public class PalindromeCheckTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your String:");
        String string = scanner.nextLine();
        PalindromeCheck.check(string);
    }
}
