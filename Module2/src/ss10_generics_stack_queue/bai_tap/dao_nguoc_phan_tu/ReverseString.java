package ss10_generics_stack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creating the OG String Stack
        Stack<String> stack = new Stack<>();
        System.out.println("Please input your String:");
        String stringOriginal = scanner.nextLine();
        String[] wordsOriginal = stringOriginal.split("\\s");
        for (String word : wordsOriginal) {
            stack.push(word);
        }
        //Reversing the OG String Stack
        int sizeStack = stack.size();
        for (int i = 0; i < sizeStack; i++) {
            System.out.print(stack.pop() + ' ');
        }
    }
}
