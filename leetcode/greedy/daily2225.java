package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class daily2225 {
    public static void main(String[] args) {

    }
}

class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        // 找出输掉零场或一场比赛的玩家
        // 思路：哈希表

        // 先找到所以输过比赛的，如果输过比赛则不能加入w
        Map<Integer, Integer> w = new HashMap<>();
        Map<Integer, Integer> l = new HashMap<>();
        for (int[] match : matches) {
            l.put(match[1], l.getOrDefault(match[1], 0) + 1);
        }
        for (int[] match : matches) {
            if (l.getOrDefault(match[0], 0) == 0) {
                w.put(match[0], w.getOrDefault(match[0], 0) + 1);
            }
        }

        List<Integer> wR = new ArrayList<>();
        for (var e : w.entrySet()) {
            if (e.getValue() > 0) {
                wR.add(e.getKey());
            }
        }
        Collections.sort(wR);
        List<Integer> lR = new ArrayList<>();
        for (var e : l.entrySet()) {
            if (e.getValue() == 1) {
                lR.add(e.getKey());
            }
        }
        Collections.sort(lR);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(wR);
        ans.add(lR);

        return ans;
    }
}
