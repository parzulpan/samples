package array_string;

import java.util.Objects;

public class daily2864 {
    public static void main(String[] args) {
        Solution2864 solution = new Solution2864();

        // case1
        System.out.println(solution.maximumOddBinaryNumber("010"));
        // case2
        System.out.println(solution.maximumOddBinaryNumber("0101"));
        // case2
        System.out.println(solution.maximumOddBinaryNumber("01101"));
    }
}

class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        // 最大二进制奇数
        // 思路1：字符串模拟处理即可

        String ans = "";
        boolean oddFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (Objects.equals(s.charAt(i), '1')) {
                if (!oddFlag) {
                    oddFlag = true;
                } else {
                    ans = "1" + ans;
                }
            } else {
                ans = ans + "0";
            }
        }

        if (oddFlag) {
            ans = ans + "1";
        }

        return ans;
    }

    public String maximumOddBinaryNumber2(String s) {
        // 最大二进制奇数
        // 思路2：统计 1 的个数

        int oneCnt = s.length() - s.replace("1", "").length();

        return "1".repeat(oneCnt - 1) + "0".repeat(s.length() - oneCnt) + "1";
    }
}
