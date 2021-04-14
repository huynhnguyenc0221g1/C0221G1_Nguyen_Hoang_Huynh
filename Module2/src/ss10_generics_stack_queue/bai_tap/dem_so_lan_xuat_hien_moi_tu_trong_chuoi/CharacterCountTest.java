package ss10_generics_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_chuoi;

import java.util.*;

public class CharacterCountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a string:");
        String string = scanner.nextLine();
        System.out.println(CharacterCount.count(string));
    }
}
