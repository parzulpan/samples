package _testjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testtime {
    public static void main(String[] args) {
        String input = "${request.extendParams.extendedData.orderId?js_string}";
        String input2 = "${request.extendParams.oid}";

        String orderId = extractValue(input);
        String oid = extractValue(input2);

        System.out.println("Extracted orderId: " + orderId);
        System.out.println("Extracted oid: " + oid);
    }

    private static String extractValue(String input) {
        String pattern = "\\$\\{[^}]+\\.(\\w+)(\\?.+)?\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        if (m.find()) {
            return m.group(1);
        }

        return null;
    }
}
