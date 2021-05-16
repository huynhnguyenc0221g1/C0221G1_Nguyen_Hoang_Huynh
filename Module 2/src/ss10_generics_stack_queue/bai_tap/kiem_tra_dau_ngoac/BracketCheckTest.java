package ss10_generics_stack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.*;

public class BracketCheckTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a expression:");
        String expression = scanner.nextLine();
        System.out.println(BracketCheck.check(expression));
    }
}
