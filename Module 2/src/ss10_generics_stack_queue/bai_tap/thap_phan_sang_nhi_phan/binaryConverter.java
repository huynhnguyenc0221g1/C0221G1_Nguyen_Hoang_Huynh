package ss10_generics_stack_queue.bai_tap.thap_phan_sang_nhi_phan;
import java.util.*;
public class binaryConverter {
    public static String converter(int number) {
        Stack<Integer> stack = new Stack<>();
        String result = "";
        int numberCheck = number;
        if (numberCheck < 0) {
            result += "-";
            number = Math.abs(number);
        }
        if (numberCheck == 0) {
            return result = "0";
        }
        if (numberCheck == 1) {
            return result = "1";
        }
        if (numberCheck == -1) {
            return result = "-1";
        }
        while ((int) number / 2 != 0) {
            if (number > 0) {
                int binary1 = (int) number % 2;
                stack.push(binary1);
                number = number / 2;
                if ((int) number / 2 == 0) {
                    stack.push(1);
                }
            }
        }
        int sizeStack = stack.size();
        for (int i = 0; i < sizeStack; i++) {
            result += stack.pop();
        }
        return result;
    }
}
