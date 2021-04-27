package ss16_binary_file.bai_tap.quan_ly_san_pham;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try {
            Product iphone = new Product(12, "iphone", "apple", 1000, "light weight");
            Product samsung = new Product(21, "samsung", "samsung", 1500, "foldable");
            Product[] products = {iphone, samsung};
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("srcproducts.dat"));
        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }
}
