package _testjava;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class testtimezone {
    public static void main(String[] args) {
        tz();

        // long timeMillis = System.currentTimeMillis() + 1000 * 50 * 60;
        // System.out.println("timeMillis: " + timeMillis);

        // System.out.println("US: " + convertTimezone1(timeMillis, -18000));
        // System.out.println("CN: " + convertTimezone1(timeMillis, 28800));
        // System.out.println("KR: " + convertTimezone1(timeMillis, 32400));
    }

    public static long convertTimezone1(long specificTime, int timezoneOffsetSeconds) {
        // 将偏移量转换为毫秒
        long offsetMillis = timezoneOffsetSeconds * 1000;

        // 创建Calendar实例，并设置特定时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(specificTime);

        // 获取UTC时间与北京时间的偏移量
        int offsetToUTC = calendar.getTimeZone().getOffset(calendar.getTimeInMillis());
        // 北京时间的偏移量（毫秒）
        long beijingOffsetMillis = TimeUnit.HOURS.toMillis(8);

        // 调整时间戳到北京时间
        // 首先减去入参的偏移量，转换为UTC时间
        // 然后加上北京时间的偏移量
        long beijingTimeMillis = specificTime - offsetMillis + beijingOffsetMillis;

        return beijingTimeMillis;
    }

    public static void tz() {
        LocalDateTime plusDays = LocalDateTime.now().plusDays(3);
        System.out.println(plusDays);
        long epochMilli = plusDays.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(epochMilli);

        long bjOffsetMillis = TimeUnit.HOURS.toMillis(8);

        long usOffsetMillis = -18000 * 1000;
        long krOffsetMillis = 32400 * 1000;

        long targetUSMillis = epochMilli + usOffsetMillis - bjOffsetMillis;
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(targetUSMillis), ZoneId.systemDefault()));
        long targetKRMillis = epochMilli + krOffsetMillis - bjOffsetMillis;
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(targetKRMillis), ZoneId.systemDefault()));

    }
}
