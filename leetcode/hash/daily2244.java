package hash;

import java.util.HashMap;

public class daily2244 {
    public static void main(String[] args) {

    }
}

class Solution2244 {
    public int minimumRounds(int[] tasks) {
        // 完成所有任务需要的最少轮数
        // 思路：哈希遍历

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int t : tasks) {
            map.merge(t, 1, Integer::sum);
        }

        int ans = 0;
        for (Integer v : map.values()) {
            if (v == 1) {
                return -1;
            }

            //
            ans += v / 3 + (v % 3 == 0 ? 0 : 1);
        }

        return ans;
    }
}
