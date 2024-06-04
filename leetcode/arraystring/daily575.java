package arraystring;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class daily575 {
    public static void main(String[] args) {

    }
}

class Solution575 {
    public int distributeCandies(int[] candyType) {
        // 分糖果
        // 思路：按题意处理即可

        int n = candyType.length / 2;

        Set<Integer> collect = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        if (collect.size() >= n) {
            return n;
        }

        return collect.size();
    }
}
