package ss2_java_loop.bai_tap;

public class So_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        System.out.println("Prime numbers less than 100 are:");
        System.out.println(2);
        int num = 3;
        boolean check = true;
        while (num<100) {
            for (int i = 2 ; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.println(num);
            }
            check=true;
            num++;
        }
    }
}
