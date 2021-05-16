package commons;

public class IOConvert {
    public static String normalizeString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.substring(0,1).toUpperCase());
        stringBuilder.append(string.substring(1).toLowerCase());

        return stringBuilder.toString();
    }
}
