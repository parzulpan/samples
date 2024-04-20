package greedy;

public class daily1702 {
    public static void main(String[] args) {

    }
}

class Solution1702 {
    public String maximumBinaryString(String binary) {
        // 修改后的最大二进制字符串
        // 思路：分析+贪心
        // 1. 答案不会包含 00（连续的 0）
        // 2. 答案至多包含一个 0
        // 3. 如果 binary 全是 1，那么返回 binary 即可；如果 binary 中有 0，那么最终答案会恰好包含一个 0；

        int i = binary.indexOf('0');

        // binary 全是 1
        if (i < 0) {
            return binary;
        }

        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (i++; i < s.length; i++) {
            // 统计 [i, n-1] 中 '1' 的个数
            cnt1 += s[i] - '0';
        }

        return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
    }
}
