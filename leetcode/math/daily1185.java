package math;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class daily1185 {
    public static void main(String[] args) {
        Solution1158 solution = new Solution1158();

        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
        System.out.println(solution.dayOfTheWeek(15, 8, 1993));
    }

}

class Solution1158 {

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        // String ans = localDate.getDayOfWeek().toString();
        // return ans.substring(0, 1) + ans.substring(1).toLowerCase();

        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
    }
}
