/**
 *  这道题主要是熟悉下java的日期方法
 *  month都是从0开始的,date的年的0是用1900来算的
 */

import java.util.Calendar;
import java.util.Date;
class Solution {
    private static final String[] WEEK_DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
    //Date解法
    public String dayOfTheWeek(int day, int month, int year) {
        Date date = new Date(year - 1900, month - 1, day);
        int days = (int) ((date.getTime() - 31507200000L) / 3600 / 24 / 1000);
        return WEEK_DAYS[(days + 5) % 7];
    }

    //Calendar解法
    public String dayOfTheWeek1(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return WEEK_DAYS[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}