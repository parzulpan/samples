package array_string;

public class daily303 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

/**
 * 区域和检索 - 数组不可变
 * 思路1：按题意模拟即可
 * 思路2：前缀和
 * 
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
class NumArray {
    // private int[] nums;

    // public NumArray(int[] nums) {
    // this.nums = nums;
    // }

    // public int sumRange(int left, int right) {
    // int ans = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (left <= i && right >= i) {
    // ans += nums[i];
    // }
    // }

    // return ans;
    // }

    private int[] s;

    public NumArray(int[] nums) {
        int n = nums.length;
        // s[0] 为 0
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}
