package math;

import java.util.ArrayList;
import java.util.List;

public class lc1296 {
    public static void main(String[] args) {
        Solution1296 solution = new Solution1296();
        List<Integer> ans1 = solution.numOfBurgers(16, 7);
        System.out.println(ans1);

    }
}

class Solution1296 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(cheeseSlices * 2 - tomatoSlices / 2);

        return ans;
    }
}