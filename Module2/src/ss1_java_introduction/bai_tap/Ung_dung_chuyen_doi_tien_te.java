package ss1_java_introduction.bai_tap;
import java.util.Scanner;
public class Ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float vnd,usd;
        System.out.println("Input Vietnamese Dong amount (Conversion rate is VND 23000 = $1):");
        vnd = scanner.nextFloat();
        usd = vnd / 23000;
        System.out.println("US Dollar amount: $ " + usd);
    }
}
