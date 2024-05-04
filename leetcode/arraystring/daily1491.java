package arraystring;

import java.util.Arrays;

public class daily1491 {
    public static void main(String[] args) {

    }
}

class Solution1491 {
    public double average(int[] salary) {
        // 去掉最低工资和最高工资后的工资平均值
        // 思路：按照题意处理即可

        Arrays.sort(salary);
        int total = 0;
        int cnt = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            total += salary[i];
            cnt++;
        }

        // double 返回
        return total * 1.0 / cnt;
    }
}
