package array_string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class daily2129 {
    public static void main(String[] args) {
        Solution2129 solution = new Solution2129();

        // case1
        System.out.println(solution.capitalizeTitle("capiTalIze tHe titLe"));

        // case2
        System.out.println(solution.capitalizeTitle("First leTTeR of EACH Word"));

        // case3
        System.out.println(solution.capitalizeTitle("i lOve leetcode"));
    }
}

class Solution2129 {
    public String capitalizeTitle(String title) {
        // 将标题首字母大写
        // 思路：模拟处理字符串即可

        return Arrays.stream(title.split(" "))
                .map(w -> w.length() <= 2 ? w.toLowerCase()
                        : w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
