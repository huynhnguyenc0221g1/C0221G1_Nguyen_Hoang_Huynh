package ss10_generics_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_chuoi;
import java.util.*;
public class CharacterCount {
    public static TreeMap<Character,Integer> count(String string) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        String lowerCaseString = "";
        for (int i = 0; i < string.length(); i++) {
            lowerCaseString += Character.toLowerCase(string.charAt(i));
        }
        for (int i = 0; i < lowerCaseString.length(); i++) {
            char character = lowerCaseString.charAt(i);
            boolean contains = treeMap.containsKey(character);
            if (!contains) {
                treeMap.put(character, 1);
            } else {
                treeMap.put(character, treeMap.get(character) + 1);
            }
        }
        treeMap.remove(' ');
        return treeMap;
    }
}
