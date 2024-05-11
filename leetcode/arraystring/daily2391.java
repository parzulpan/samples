package arraystring;

import java.util.HashMap;

public class daily2391 {
    public static void main(String[] args) {

    }
}

class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        // 收集垃圾的最少总时间
        // 思路：哈希+前缀和

        HashMap<Character, Integer> last = new HashMap<>(3);
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            ans += s.length();
            for (char c : s.toCharArray()) {
                last.put(c, i);
            }
        }

        int ts = 0;
        for (int i = 1; i <= travel.length; i++) {
            ts += travel[i - 1];
            for (Integer j : last.values()) {
                if (i == j) {
                    ans += ts;
                }
            }
        }

        return ans;
    }
}
