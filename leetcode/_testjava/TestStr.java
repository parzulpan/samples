package _testjava;

import java.util.Arrays;

public class TestStr {
    public static void main(String[] args) {
        String text1 = "20240229_push_panpantest11_testsend_en_VariantA";
        String text2 = "all20240229wclastcall_en_VariantA";
        extractParts(text1);
        extractParts(text2);
    }

    public static void extractParts(String text) {
        String[] parts = text.split("_");
        if (parts.length < 3) {
            System.out.println("The input string does not contain enough parts.");
            return;
        }

        // 获取最后两个值
        String languageCode = parts[parts.length - 2];
        String variant = parts[parts.length - 1];

        // 将前面的所有部分组合起来作为第一个字符串
        StringBuilder dateAndNameBuilder = new StringBuilder();
        for (int i = 0; i < parts.length - 2; i++) {
            dateAndNameBuilder.append(parts[i]);
            if (i < parts.length - 3) {
                dateAndNameBuilder.append("_");
            }
        }
        String dateAndName = dateAndNameBuilder.toString();

        // 输出结果
        System.out.println(String.join("_", Arrays.copyOfRange(parts, 0, parts.length - 2)));
        System.out.println("Date and Name: " + dateAndName);
        System.out.println("Language Code: " + languageCode);
        System.out.println("Variant: " + variant);
    }
}
