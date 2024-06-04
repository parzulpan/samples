package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class daily2831 {
    public static void main(String[] args) {

    }
}

class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        // 找出最长等值子数组
        // 思路：滑动窗口

        int n = nums.size();
        List<Integer>[] posLists = new ArrayList[n + 1];
        Arrays.setAll(posLists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            posLists[x].add(i - posLists[x].size());
        }

        int ans = 0;
        for (List<Integer> pos : posLists) {
            if (pos.size() <= ans) {
                continue; // 无法让 ans 变得更大
            }
            int left = 0;
            for (int right = 0; right < pos.size(); right++) {
                while (pos.get(right) - pos.get(left) > k) { // 要删除的数太多了
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
