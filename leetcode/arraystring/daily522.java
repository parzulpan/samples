package arraystring;

public class daily522 {
    public static void main(String[] args) {

    }
}

class Solution522 {
    public int findLUSlength(String[] strs) {
        // 最长特殊序列 II
        // 思路：枚举+判断子序列

        int ans = -1;
        next: for (int i = 0; i < strs.length; i++) {
            // 不会让 ans 变大
            if (strs[i].length() <= ans) {
                continue;
            }
            for (int j = 0; j < strs.length; j++) {
                if (j != i && isSubsequence(strs[i], strs[j])) {
                    // 说明 strs[i] 是 strs[j] 的子串，不能更新ans
                    // 使用类似 goto 的语句
                    continue next;
                }
            }
            ans = strs[i].length();
        }

        return ans;
    }

    /**
     * 判断 s 是否为 t 的子序列
     */
    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            // 所有字符匹配完毕
            if (s.charAt(i) == c && ++i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
