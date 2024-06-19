package arraystring;

public class daily3038 {
    public static void main(String[] args) {

    }
}

class Solution3038 {
    public int maxOperations(int[] nums) {
        // 相同分数的最大操作数目 I
        // 思路：模拟即可

        int target = nums[0] + nums[1];
        int res = 0;
        int n = nums.length;
        for (int i = 0; i + 1 < n && nums[i] + nums[i + 1] == target; i += 2) {
            ++res;
        }

        return res;
    }
}
