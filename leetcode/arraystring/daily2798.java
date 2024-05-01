public class daily2798 {
    public static void main(String[] args) {

    }
}

class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        // 满足目标工作时长的员工数目
        // 思路：按照题意处理即可

        int ans = 0;
        for (int h : hours) {
            if (h >= target) {
                ans++;
            }
        }

        return ans;
    }
}
