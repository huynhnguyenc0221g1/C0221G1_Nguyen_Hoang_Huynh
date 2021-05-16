package commons;

public class IOString {
    public static final String COMMA = ",";
    public static final String CSV = ".csv";
    public static String concat(String[] data, String character){
        StringBuffer outputString = new StringBuffer(data[0]);
        for (int i = 1; i<data.length;i++) {
            outputString.append(character);
            outputString.append(data[i]);
        }

        return outputString.toString();
    }
}
