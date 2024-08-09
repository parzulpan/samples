package math;

public class daily2844 {
    public static void main(String[] args) {

    }
}

class Solution2844 {
    public int minimumOperations(String num) {
        // 生成特殊数字的最少操作
        // 思路：枚举末尾
        // 1. 一个数能被 25 整除，有五种情况：这个数是0；这个数的末尾是00；这个数的末尾是25；这个数的末尾是50；这个数的末尾是75；

        // 兜底结果
        int zero = num.length() - (num.contains("0") ? 1 : 0);

        return min(zero, f(num, "00"), f(num, "25"), f(num, "50"), f(num, "75"));
    }

    private int f(String num, String tail) {
        int n = num.length();
        int i = num.lastIndexOf(tail.charAt(1));
        if (i <= 0) {
            return n;
        }
        i = num.lastIndexOf(tail.charAt(0), i - 1);
        return i < 0 ? n : n - i - 2;
    }

    private int min(int x, int... y) {
        for (int i : y) {
            x = Math.min(x, i);
        }
        return x;
    }
}
