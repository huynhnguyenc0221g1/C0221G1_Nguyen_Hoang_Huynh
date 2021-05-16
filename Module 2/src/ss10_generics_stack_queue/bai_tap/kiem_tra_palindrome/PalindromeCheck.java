package ss10_generics_stack_queue.bai_tap.kiem_tra_palindrome;

import java.util.*;

public class PalindromeCheck {
    public static void check(String string) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        boolean nullCheck = string.equals("");
        if (nullCheck) {
            System.out.println("The String is a Palindrome!");
        } else {
            for (int i = 0; i < string.length(); i++) {
                stack.push(string.charAt(i));
                queue.add(string.charAt(i));
            }
            //Comparing stack and queue to check the Palindrome status of the String
            int count = 0;
            char stackCharacter;
            char queueCharacter;
            for (int i = 0; i < string.length(); i++) {
                stackCharacter = stack.pop();
                queueCharacter = queue.remove();
                boolean sameCharacter = stackCharacter == queueCharacter
                        || stackCharacter == Character.toLowerCase(queueCharacter)
                        || stackCharacter == Character.toUpperCase(queueCharacter);
                if (sameCharacter) {
                    count++;
                }
            }
            if (count == string.length()) {
                System.out.println("The String is a Palindrome!");
            } else {
                System.out.println("The String is not a Palindrome!");
            }
        }
    }
}
