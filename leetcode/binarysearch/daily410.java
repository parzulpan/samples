package binarysearch;

public class daily410 {
    public static void main(String[] args) {
        Solution410 solution = new Solution410();

        // case1
        System.out.println(solution.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        // case2
        System.out.println(solution.splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
        // case3
        System.out.println(solution.splitArray(new int[] { 1, 4, 4 }, 3));
    }
}

class Solution410 {
    public int splitArray(int[] nums, int k) {
        // 看到「最大化最小值」或者「最小化最大值」就要想到二分查找
        int sum = 0;
        int mx = 0;
        for (int x : nums) {
            sum += x;
            mx = Math.max(mx, x);
        }

        int left = Math.max(mx - 1, (sum - 1) / k);
        int right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int cnt = 1;
        int s = 0;
        for (int x : nums) {
            if (s + x <= mx) {
                s += x;
            } else {
                if (cnt == k) {
                    return false;
                }
                cnt += 1;
                s = x;
            }
        }

        return true;
    }
}
