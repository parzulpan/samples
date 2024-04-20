package arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class daily2788 {
    public static void main(String[] args) {
        Solution2788 solution = new Solution2788();

        // case1
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
        // case2
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$'));
        // case3
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("|||"), '|'));
    }
}

class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> ans = new ArrayList<String>();
        for (String word : words) {
            String[] split = word.split("\\" + separator);
            if (split.length != 0) {
                for (String s : split) {
                    if (!Objects.equals(s, "") && !Objects.equals(s, String.valueOf(separator))) {
                        ans.add(s);
                    }
                }
            }
        }

        return ans;
    }
}
