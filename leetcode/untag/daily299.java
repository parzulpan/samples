package untag;

import java.util.HashMap;
import java.util.Map;

public class daily299 {
    public static void main(String[] args) {
        Solution299 solution = new Solution299();

        // case1
        System.out.println(solution.getHint("1807", "7810"));

        // case2
        System.out.println(solution.getHint("1123", "0111"));

    }
}

class Solution299 {
    public String getHint(String secret, String guess) {
        // 猜数字游戏
        // 思路：读懂题意，将字符串放入哈希表模拟即可

        int bullsCnt = 0, cowsCnt = 0;
        int n = secret.length();
        Map<Integer, Integer> bullsMap = new HashMap<>();
        Map<Integer, Integer> cowsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bullsCnt += 1;
            } else {
                bullsMap.put(s - '0', bullsMap.getOrDefault(s - '0', 0) + 1);
                cowsMap.put(g - '0', cowsMap.getOrDefault(g - '0', 0) + 1);
            }
        }

        // 出现次数最小的
        for (int i = 0; i < 10; i++) {
            cowsCnt += Math.min(bullsMap.getOrDefault(i, 0), cowsMap.getOrDefault(i, 0));
        }

        return String.format("%dA%dB", bullsCnt, cowsCnt);
    }
}
