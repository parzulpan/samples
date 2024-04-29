package simulate;

public class daily2739 {
    public static void main(String[] args) {

    }
}

class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        // 总行驶距离
        // 思路：模拟即可

        int ans = 0;
        if (mainTank < 5) {
            return mainTank * 10;
        }

        while (mainTank > 0) {
            mainTank = mainTank - 5;
            if (additionalTank > 0) {
                ++mainTank;
                --additionalTank;
            }
            ans = ans + 5;
            if (mainTank < 5) {
                ans = ans + mainTank;
                break;
            }
        }

        return ans * 10;
    }
}
