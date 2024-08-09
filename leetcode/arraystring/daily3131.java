package arraystring;

public class daily3131 {
    public static void main(String[] args) {

    }
}

class Solution3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        // 找出与数组相加的整数 I
        // 思路：求和后处理即可

        int sum1 = 0, sum2 = 0;
        for (int x : nums1) {
            sum1 += x;
        }
        for (int x : nums2) {
            sum2 += x;
        }

        return (sum2 - sum1) / nums1.length;
    }
}
