package arraystring;

public class daily2288 {
    public static void main(String[] args) {

    }
}

class Solution2288 {
    public String discountPrices(String sentence, int discount) {
        // 价格减免
        // 思路：空格分隔+替换

        double d = 1 - discount / 100.0;
        String[] a = sentence.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (check(a[i])) {
                a[i] = String.format("$%.2f", Long.parseLong(a[i].substring(1)) * d);
            }
        }

        return String.join(" ", a);
    }

    private boolean check(String string) {
        if (string.length() == 1 || string.charAt(0) != '$') {
            return false;
        }
        char[] s = string.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (!Character.isDigit(s[i])) {
                return false;
            }
        }

        return true;
    }
}