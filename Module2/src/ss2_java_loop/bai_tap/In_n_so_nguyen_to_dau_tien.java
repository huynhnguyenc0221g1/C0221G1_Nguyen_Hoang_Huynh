package ss2_java_loop.bai_tap;
import java.util.Scanner;
public class In_n_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int num = 3;
        int amount;
        System.out.println("Please input the amount of first prime numbers that you want to see:");
        amount = scanner.nextInt();
        System.out.println("First " + amount + " prime numbers are:");
        System.out.println(2);
        for (int count = 0; count < amount-1; ) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.println(num);
                count++;
            }
            check = true;
            num++;
        }
    }
}
