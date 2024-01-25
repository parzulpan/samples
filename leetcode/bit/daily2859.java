package bit;

import java.util.Arrays;
import java.util.List;

public class daily2859 {
    public static void main(String[] args) {
        Solution2895 solution = new Solution2895();

        // case1
        System.out.println(solution.sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 1));
        // case2
        System.out.println(solution.sumIndicesWithKSetBits(Arrays.asList(4, 3, 2, 1), 2));
    }
}

class Solution2895 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int size = nums.size();
        int ans = 0;
        for (int i = 0; i < size; i++) {
            // if (Integer.bitCount(i) == k) {
            // ans += nums.get(i);
            // }
            if (bitCount(i) == k) {
                ans += nums.get(i);
            }
        }

        return ans;
    }

    /**
     * 使用Brian Kernighan算法。该算法的基本思想是：对于任意整数n，n & (n - 1)总是能把n的最低位的1变成0，并保持其他位不变。
     */
    private int bitCount(int i) {
        int count = 0;
        while (i != 0) {
            i &= (i - 1);
            count++;
        }

        return count;
    }
}
