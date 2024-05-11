package arraystring;

public class daily1652 {
    public static void main(String[] args) {

    }
}

class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        // 拆炸弹
        // 思路：按题意处理即可

        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + 1 + k; j++) {
                    ans[i] += code[j % n];
                }
            } else {
                for (int j = i + k; j < i; j++) {
                    ans[i] += code[(j + n) % n];
                }
            }
        }

        return ans;
    }
}
