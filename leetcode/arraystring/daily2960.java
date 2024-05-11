package arraystring;

public class daily2960 {
    public static void main(String[] args) {

    }
}

class Solution2960 {
    private int[] batteryPercentages;

    public int countTestedDevices(int[] batteryPercentages) {
        // 统计已测试设备
        // 思路：按题意处理即可

        this.batteryPercentages = batteryPercentages;
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                ans++;
                update(i + 1);
            }
        }

        return ans;
    }

    private void update(int index) {
        for (int i = index; i < this.batteryPercentages.length; i++) {
            this.batteryPercentages[i] = Math.max(0, this.batteryPercentages[i] - 1);
        }
    }
}
