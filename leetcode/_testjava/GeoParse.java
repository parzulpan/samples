package _testjava;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class GeoParse {
    public static void main(String[] args) {
        System.out.println(parseGeoString(
                "georegion=180,country_code=RO,city=SFANTUGHEORGHE,lat=45.87,long=25.78,timezone=GMT+2,continent=EU,throughput=vhigh,bw=5000,asn"));
        System.out.println(parseGeoString(
                "georegion=118,country_code=KR,city=SEOUL,lat=37.57,long=127.00,timezone=GMT+9,continent=AS,throughput=vhigh,bw=5000,asnum=9316,"));
        System.out.println(parseGeoString(
                "georegion=208,country_code=SE,region_code=O,city=GOTHENBURG,lat=57.72,long=11.97,timezone=GMT+1,continent=EU,throughput=vhigh,b"));
        System.out.println(parseGeoString(
                "georegion=77,country_code=FR,region_code=IDF,city=PARIS,lat=48.87,long=2.33,timezone=GMT+1,continent=EU,throughput=vhigh,bw=500"));
    }

    private static Map<String, String> parseGeoString(String geoString) {
        Map<String, String> parsedValues = new HashMap<>();
        Pattern pattern = Pattern.compile("(country_code|region_code|city)=([^,]+)");
        java.util.regex.Matcher matcher = pattern.matcher(geoString);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            parsedValues.put(key, value);
        }

        return parsedValues;
    }
}
