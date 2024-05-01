package array_string;

public class daily2810 {
    public static void main(String[] args) {
        Solution2810 solution = new Solution2810();

        // case1
        System.out.println(solution.finalString("string"));
        // case2
        System.out.println(solution.finalString("poiinter"));
    }
}

class Solution2810 {
    public String finalString(String s) {
        // 故障键盘
        // 思路：模拟即可

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                ans = ans.reverse();
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}