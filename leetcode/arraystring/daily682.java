package arraystring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class daily682 {
    public static void main(String[] args) {
        Solution682 solution = new Solution682();

        // case1
        System.out.println(solution.calPoints(new String[] { "5", "2", "C", "D", "+"
        }));
        // case2
        System.out.println(solution.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
    }
}

class Solution682 {
    public int calPoints(String[] operations) {
        // 棒球比赛
        // 思路：按题意模拟即可

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < operations.length; i++) {
            String v = operations[i];
            if (Objects.equals(v, "+")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                stack.push(v2);
                stack.push(v1);
                stack.push(v1 + v2);
            } else if (Objects.equals(v, "D")) {
                stack.push(stack.peek() * 2);
            } else if (Objects.equals(v, "C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(v));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
