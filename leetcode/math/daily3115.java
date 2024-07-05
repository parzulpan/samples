package math;

public class daily3115 {
    public static void main(String[] args) {

    }
}

class Solution3115 {
    public int maximumPrimeDifference(int[] nums) {
        // 质数的最大距离
        // 思路: 按题意处理即可

        int minI = -1, maxI = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (minI == -1) {
                    minI = i;
                } else {
                    maxI = i;
                }
            }
        }

        return minI == -1 || maxI == -1 ? 0 : maxI - minI;
    }

    /**
     * 判断是否是质数
     */
    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
