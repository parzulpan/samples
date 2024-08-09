package _testjava;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestT {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int iterations = 1000000; // 测试次数
        int maxLength = 100; // 最大字符串长度

        // 生成随机字符串
        String[] testStrings = generateRandomStrings(iterations, maxLength);

        long startTime = System.nanoTime();

        // 使用正则表达式
        for (String s : testStrings) {
            isNumericRegex(s);
        }

        long endTime = System.nanoTime();
        long regexTime = endTime - startTime;
        System.out.println("Regex time: " + TimeUnit.NANOSECONDS.toMillis(regexTime) + " ms");

        startTime = System.nanoTime();

        // 使用逐个字符检查
        for (String s : testStrings) {
            isNumericCharByChar(s);
        }

        endTime = System.nanoTime();
        long charByCharTime = endTime - startTime;
        System.out.println("Char by char time: " + TimeUnit.NANOSECONDS.toMillis(charByCharTime) + " ms");

        // 比较执行时间
        if (regexTime < charByCharTime) {
            System.out.println("Regex method is faster.");
        } else if (regexTime > charByCharTime) {
            System.out.println("Char by char method is faster.");
        } else {
            System.out.println("Both methods have the same performance.");
        }
    }

    private static boolean isNumericRegex(String str) {
        return str.matches("\\d+");
    }

    private static boolean isNumericCharByChar(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static String[] generateRandomStrings(int iterations, int maxLength) {
        String[] strings = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int length = random.nextInt(maxLength) + 1;
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                sb.append(random.nextInt(10));
            }
            strings[i] = sb.toString();
        }
        return strings;
    }
}
