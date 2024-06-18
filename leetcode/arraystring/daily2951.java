package arraystring;

import java.util.ArrayList;
import java.util.List;

public class daily2951 {
    public static void main(String[] args) {

    }
}

class Solution2951 {
    public List<Integer> findPeaks(int[] mountain) {
        // 找出峰值
        // 思路：按题意处理即可

        int n = mountain.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                res.add(i);
            }
        }

        return res;
    }
}
