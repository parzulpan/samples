package lookback;

import java.util.ArrayList;
import java.util.List;

public class daily216 {
    public static void main(String[] args) {

    }
}

class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 组合总和 III
        // 思路：二进制枚举

        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << 9; ++mask) {
            if (Integer.bitCount(mask) == k) {
                List<Integer> t = new ArrayList<>();
                int s = 0;
                for (int i = 0; i < 9; ++i) {
                    if ((mask >> i & 1) == 1) {
                        s += (i + 1);
                        t.add(i + 1);
                    }
                }
                if (s == n) {
                    ans.add(t);
                }
            }
        }

        return ans;
    }
}
