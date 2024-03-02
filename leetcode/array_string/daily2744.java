package array_string;

import java.util.HashSet;

public class daily2744 {
    public static void main(String[] args) {
        Solution2744 solution = new Solution2744();

        // case1
        System.out.println(solution.maximumNumberOfStringPairs(new String[] { "cd", "ac", "dc", "ca", "zz" }));
        // case2
        System.out.println(solution.maximumNumberOfStringPairs(new String[] { "ab", "ba", "cc" }));
        // case3
        System.out.println(solution.maximumNumberOfStringPairs(new String[] { "aa", "ab" }));
    }
}

class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            // 单词反转
            String wordR = new StringBuilder(word).reverse().toString();
            if (set.contains(wordR)) {
                set.remove(wordR);
                ans++;
            } else {
                set.add(word);
            }
        }

        return ans;
    }
}
