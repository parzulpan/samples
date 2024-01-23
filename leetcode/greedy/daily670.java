package greedy;

public class daily670 {
    public static void main(String[] args) {
        Solution670 solution = new Solution670();

        // case1
        System.err.println(solution.maximumSwap(2736));
        // case2
        System.err.println(solution.maximumSwap(9973));
    }
}

class Solution670 {
    public int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s[i] <= s[d[i + 1]]) {
                d[i] = d[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            int j = d[i];
            if (s[i] < s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(s));
    }
}
