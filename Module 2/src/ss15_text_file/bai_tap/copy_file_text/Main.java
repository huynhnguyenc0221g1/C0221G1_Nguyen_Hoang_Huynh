package ss15_text_file.bai_tap.copy_file_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/ss15_text_file/bai_tap/copy_file_text/output.txt"));
            bw.write("1. Travis Scott\n");
            bw.write("2. J. Cole\n");
            bw.write("3. Kendrick Lamar\n");
            bw.write("4. Drake\n");
            bw.close();
        } catch (Exception e) {
            return;
        }
        System.out.println("Successfully created output.txt file in your package path!");
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/ss15_text_file/bai_tap/copy_file_text/output-copy.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("src/ss15_text_file/bai_tap/copy_file_text/output.txt"));
            String string;
            while ((string = br.readLine()) != null) {
                bw.write(string + "\n");
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            return;
        }
        System.out.println("Successfully created output-copy.txt with the data from output.txt");
    }
}

