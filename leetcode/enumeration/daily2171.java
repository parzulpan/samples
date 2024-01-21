package enumeration;

import java.util.Arrays;

public class daily2171 {
    public static void main(String[] args) {
        Solution2171 solution = new Solution2171();

        // case1
        System.out.println(solution.minimumRemoval(new int[] { 4, 1, 6, 5 }));

        // case2
        System.out.println(solution.minimumRemoval(new int[] { 2, 10, 3, 2 }));
    }
}

class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0, max = 0;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
            max = Math.max(max, (long) (n - i) * beans[i]);
        }

        return sum - max;
    }
}
