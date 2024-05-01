package slidingwindow;

public class daily1052 {
    public static void main(String[] args) {

    }
}

class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 爱生气的书店老板
        // 思路：滑动窗口
        // 1. 先将原本就满意的客户加入答案，同时将对应的 customers[i] 变为 0
        // 2. 之后的问题转化为：在 customers 中找到连续一段长度为 minutes 的子数组，使得其总和最大。这部分y运用滑动窗口即可

        int n = customers.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }

        int cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if (i >= minutes) {
                cur -= customers[i - minutes];
            }
            max = Math.max(max, cur);
        }

        return ans + max;
    }
}
