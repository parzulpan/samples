package _testjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class TimeZoneMapBuilder {

    public static Map<String, Integer> buildTimeZoneMap(String zoneTabPath) throws IOException {
        Map<String, Integer> countryTimezoneMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(zoneTabPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip comments and empty lines
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split("\t");
                // Ensure the line has at least 3 parts: country code, coordinates, and TZ
                // identifier
                String countryCode = parts[0];
                String timeZoneId = parts[2];
                try {
                    if (parts.length >= 3) {
                        // Get current offset in seconds
                        ZoneId zoneId = ZoneId.of(timeZoneId);
                        ZonedDateTime now = ZonedDateTime.now(zoneId);
                        int offsetInSeconds = now.getOffset().getTotalSeconds();
                        // Put in map if not already present
                        countryTimezoneMap.putIfAbsent(countryCode, offsetInSeconds);
                    }
                } catch (Exception e) {
                    System.out.println(countryCode + " " + timeZoneId);
                }
            }
        }
        return countryTimezoneMap;
    }

    public static void main(String[] args) {
        try {
            Map<String, Integer> countryTimezoneMap = buildTimeZoneMap(
                    "/Users/parzulpan/Downloads/tzdata2023d/zone.tab");
            // Output the map - you can remove this line if you don't want to print the map
            countryTimezoneMap
                    .forEach((country, offset) -> System.out.println("put(\"" + country + "\"," + offset + ");"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
