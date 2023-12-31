package math;

import java.time.LocalDate;

public class daily1154 {
    public static void main(String[] args) {
        Solution1154 solution = new Solution1154();

        // case1
        System.out.println(solution.dayOfYear("2019-01-09"));
        // case2
        System.out.println(solution.dayOfYear("2019-02-10"));
        // case3
        System.out.println(solution.dayOfYear("2023-12-31"));
    }
}

class Solution1154 {
    int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);

        return localDate.getDayOfYear();
    }
}
