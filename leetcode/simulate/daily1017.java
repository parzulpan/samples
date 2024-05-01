package simulate;

public class daily1017 {
    public static void main(String[] args) {

    }
}

class Solution1017 {
    public String baseNeg2(int n) {
        // 负二进制转换
        // 思路：模拟即可
        // 1. 判断 n 从低位到高位的每一位，如果该位为 1，那么答案的该位为 1，否则为 0。
        // 2. 如果该位为 1，那么我们需要将 n 减去 k。
        // 3. 更新 n = n / 2，k = -k，继续判断下一位。
        // 4. 最后，将答案反转后返回即可。

        if (n == 0) {
            return "0";
        }

        int k = 1;
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if (n % 2 != 0) {
                ans.append(1);
                n -= k;
            } else {
                ans.append(0);
            }
            k *= -1;
            n /= 2;
        }

        return ans.reverse().toString();
    }
}
