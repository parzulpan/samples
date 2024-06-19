package greedy;

import java.util.Arrays;

public class daily881 {
    public static void main(String[] args) {

    }
}

class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        // 救生艇
        // 思路：贪心+双指针
        // 1. 排序后，双指针分别指向头和尾，每次取两个指针指向元素之和；
        // 2. 如果小于等于limit，则两个指针同时向中间移动一位，否则只移动右指针。

        Arrays.sort(people);
        int ans = 0;
        for (int i = 0, j = people.length - 1; i <= j; --j) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
            ++ans;
        }

        return ans;
    }
}