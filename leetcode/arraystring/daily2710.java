package arraystring;

public class daily2710 {
    public static void main(String[] args) {
        Solution2710 solution = new Solution2710();

        // case1
        System.out.println(solution.removeTrailingZeros("51230100"));
        // case2
        System.out.println(solution.removeTrailingZeros("123"));
    }
}

class Solution2710 {
    public String removeTrailingZeros(String num) {
        // 移除字符串中的尾随零
        // 思路：按题意处理即可

        int zeroIndex = num.length();
        boolean zeroFlag = true;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '0' && zeroFlag) {
                zeroIndex = i;
            } else {
                zeroFlag = false;
            }
        }

        return num.substring(0, zeroIndex);
    }
}
