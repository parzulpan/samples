package arraystring;

import java.util.Objects;

public class daily521 {
    public static void main(String[] args) {
        Solution521 s = new Solution521();
        System.out.println(s.findLUSlength("aaa", "aa"));
    }
}

class Solution521 {
    public int findLUSlength(String a, String b) {
        // 最长特殊序列 Ⅰ
        // 思路：脑筋急转弯
        // 1. 如果 a = b，那么肯定不存在独有的子序列，返回 -1
        // 2. 如果 a != b，返回 a 和 b 二者的最大长度，理由如下：
        // 2.1 如果 a 比 b 长，答案的最大值为 a 的长度，答案为 a 的长度，因为 a 作为独立子序列它肯定不是 b 的子序列
        // 2.2 如果 b 比 a 长，答案的最大值为 b 的长度
        // 2.3 如果 a 和 b 一样长，由于 a != b，答案为 a 的长度

        return Objects.equals(a, b) ? -1 : Math.max(a.length(), b.length());
    }
}
