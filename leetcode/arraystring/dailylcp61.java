package arraystring;

public class dailylcp61 {
    public static void main(String[] args) {

    }
}

class Solutionlcp61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        // 气温变化趋势
        // 思路：按照题意处理即可

        // 趋势是否相同
        int same = 0;
        int ans = 0;
        for (int i = 0; i < temperatureA.length - 1; i++) {
            // 比较
            if (Integer.compare(temperatureA[i], temperatureA[i + 1]) == Integer.compare(temperatureB[i],
                    temperatureB[i + 1])) {
                ans = Math.max(ans, ++same);
            } else {
                same = 0;
            }
        }

        return ans;
    }
}
