package arraystring;

public class daily2965 {
    public static void main(String[] args) {

    }
}

class Solution2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // 找出缺失和重复的数字
        // 思路：模拟即可

        int[] arr = new int[grid.length * grid.length + 1];
        for (int[] g : grid) {
            for (int e : g) {
                arr[e]++;
            }
        }

        int zero = 0, two = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (zero != 0 && two != 0) {
                break;
            }
            if (arr[i] == 0) {
                zero = i;
            }
            if (arr[i] == 2) {
                two = i;
            }
        }

        return new int[] { two, zero };
    }
}
