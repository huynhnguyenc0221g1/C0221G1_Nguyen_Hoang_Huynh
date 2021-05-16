package ss10_generics_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.*;

public class binaryConverterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a number");
        int number = scanner.nextInt();
        System.out.println("Converted to binary:");
        System.out.println(binaryConverter.converter(number));
    }
}

