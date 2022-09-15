package utill;

public class StringParser {

    public static int getPrice(String price) {
        String result = price.split(",")[0].replace(" ", "");
        return Integer.parseInt(result);
    }

    public static String getName() {
        return "";
    }
}
