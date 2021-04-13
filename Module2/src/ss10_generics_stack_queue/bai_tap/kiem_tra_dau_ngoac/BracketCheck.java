package ss10_generics_stack_queue.bai_tap.kiem_tra_dau_ngoac;
import java.util.*;
public class BracketCheck {
    public static boolean check(String expression) {
        Stack<Character> stack = new Stack<>();
        if (expression == "") {
            return false;
        } else {
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    stack.push('(');
                } else if (expression.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                if (expression.charAt(i) == '(' && expression.charAt(i+1) == ')') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
