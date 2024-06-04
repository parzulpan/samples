package arraystring;

import java.util.Arrays;

public class daily2093 {
    public static void main(String[] args) {
        Solution2903 solution = new Solution2903();

        // case1
        Arrays.stream(solution.findIndices(new int[] { 5, 1, 4, 1 }, 2, 4)).forEach(System.out::println);
        // case2
        Arrays.stream(solution.findIndices(new int[] { 2, 1 }, 0, 0)).forEach(System.out::println);
        // case3
        Arrays.stream(solution.findIndices(new int[] { 1, 2, 3 }, 2, 4)).forEach(System.out::println);
    }
}

class Solution2903 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // 找出满足差值条件的下标 I
        // 思路：按照题意处理即可

        int mi = 0, mx = 0;
        for (int i = indexDifference; i < nums.length; i++) {
            int j = i - indexDifference;
            if (nums[j] < nums[mi]) {
                mi = j;
            }
            if (nums[j] > nums[mx]) {
                mx = j;
            }
            if (nums[i] - nums[mi] >= valueDifference) {
                return new int[] { mi, i };
            }
            if (nums[mx] - nums[i] >= valueDifference) {
                return new int[] { mx, i };
            }
        }

        return new int[] { -1, -1 };
    }
}
