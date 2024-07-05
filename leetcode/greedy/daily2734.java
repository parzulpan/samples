package greedy;

public class daily2734 {
    public static void main(String[] args) {

    }
}

class Solution2734 {
    public String smallestString(String s) {
        // 执行子串操作后的字典序最小字符串
        // 思路：贪心

        char[] sC = s.toCharArray();
        int n = sC.length;
        for (int i = 0; i < n; i++) {
            if (sC[i] > 'a') {
                // 继续向后遍历
                for (; i < n && sC[i] > 'a'; i++) {
                    sC[i]--;
                }

                return new String(sC);
            }
        }

        // 所有字母都是 a，则改最后一位
        sC[n - 1] = 'z';

        return new String(sC);
    }
}
