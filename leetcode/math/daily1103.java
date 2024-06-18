package math;

import java.util.Arrays;

public class daily1103 {
    public static void main(String[] args) {
        Solution1103 solution = new Solution1103();

        // case1
        Arrays.stream(solution.distributeCandies(7, 4)).forEach(System.out::println);
        System.out.println();
        // case2
        Arrays.stream(solution.distributeCandies(10, 3)).forEach(System.out::println);
        System.out.println();
        // case3
        Arrays.stream(solution.distributeCandies(90, 4)).forEach(System.out::println);
        System.out.println();
    }
}

class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        // 分糖果 II
        // 思路：按题意模拟即可

        int[] ans = new int[num_people];
        int sum = 0;
        for (int i = 1, n = 0; sum <= candies; i++) {
            ans[n] += i;
            n++;
            if (n >= num_people) {
                n = 0;
            }

            sum += i;

            if (candies - sum <= i) {
                ans[n] += candies - sum;
                break;
            }
        }

        return ans;
    }
}
