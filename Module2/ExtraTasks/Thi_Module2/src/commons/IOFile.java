package commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String path;
    public static void writeFile(String[] data) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write(IOString.concat(data, IOString.COMMA));
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile() {
        List<String> arrayData = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                arrayData.add(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayData;
    }

    public static void setFilePath(String fileName) {
        StringBuffer path = new StringBuffer("src/data/");
        path.append(fileName);
        path.append(IOString.CSV);

    IOFile.path = path.toString();
    }
}
