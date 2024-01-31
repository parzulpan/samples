package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class daily2670 {
    public static void main(String[] args) {
        Solution2670 solution = new Solution2670();

        // case1 -3,-1,1,3,5
        int[] d1 = solution.distinctDifferenceArray(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(Arrays.toString(d1));

        // case2 -2,-1,0,2,3
        int[] d2 = solution.distinctDifferenceArray(new int[] { 3, 2, 3, 4, 2 });
        System.out.println(Arrays.toString(d2));
    }
}

class Solution2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Set<Integer> sufSet = new HashSet<Integer>();
        int[] sufArr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sufSet.add(nums[i]);
            sufArr[i] = sufSet.size();
        }
        sufSet.clear();
        for (int i = 0; i < n; i++) {
            sufSet.add(nums[i]);
            ans[i] = sufSet.size() - sufArr[i + 1];
        }

        return ans;
    }
}