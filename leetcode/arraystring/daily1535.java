package arraystring;

public class daily1535 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int getWinner(int[] arr, int k) {
        // 找出数组游戏的赢家
        // 思路：脑筋急转弯
        // 1. 每次会比较数组的前两个元素，不管结果怎么样，下一次的比较，一定是轮到了数组中的下一个元素和当前的胜者进行比较。
        // 2. 如果循环了 n−1 次，那么最后的胜者一定是数组中的最大元素。否则，如果某个元素连续胜出了 k 次，那么这个元素就是最后的胜者。

        int mx = arr[0];
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (mx < arr[i]) {
                mx = arr[i];
                cnt = 1;
            } else {
                ++cnt;
            }

            if (cnt == k) {
                break;
            }
        }

        return mx;
    }
}
