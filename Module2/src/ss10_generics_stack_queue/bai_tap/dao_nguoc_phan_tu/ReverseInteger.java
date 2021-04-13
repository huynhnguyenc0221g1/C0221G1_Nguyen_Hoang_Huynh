package ss10_generics_stack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.*;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        //Generating the OG Stack
        System.out.println("How many elements do you want to input:");
        int numberOfElements = scanner.nextInt();
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Element " + (i + 1) + ":");
            stack.push(scanner.nextInt());
        }
        System.out.println("Your original elements:");
        System.out.println(stack);
        //Reversing the OG Stack
        int sizeStack = stack.size();
        Stack<Integer> reversedStack = new Stack<>();
        for (int i = 0; i < sizeStack; i++) {
            reversedStack.push(stack.pop());
        }
        System.out.println("Reversed elements:");
        System.out.println(reversedStack);
    }
}
