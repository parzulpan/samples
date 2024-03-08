package _test_java;

public class testre {
    public static void main(String[] args) {
        String string1 = "AbandonCartReminder_en_A";
        String string2 = "20240303_push_UStrendonsocialmedia2_sv_VariantA";

        System.out.println(removeLastTwoSegments(string1)); // 输出 AbandonCartReminder
        System.out.println(removeLastTwoSegments(string2)); // 输出 20240303_push_UStrendonsocialmedia2
    }

    public static String removeLastTwoSegments(String text) {
        return text.replaceAll("(_[^_]+){2}$", "");
    }
}
