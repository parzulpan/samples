package _test_java;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class testab {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>() {
            {
                put("a", 70);
                put("b", 30);
            }
        };
        System.out.println(simpleAb(map1, 101));

        HashMap<String, Integer> map2 = new HashMap<>() {
            {
                put("b", 70);
                put("a", 30);
            }
        };
        System.out.println(simpleAb(map2, 101));

        HashMap<String, Integer> map3 = new HashMap<>() {
            {
                put("a", 70);
                put("b", 20);
                put("c", 10);
            }
        };
        System.out.println(simpleAb(map3, 101));

        HashMap<String, Integer> map4 = new HashMap<>() {
            {
                put("a", 20);
                put("c", 10);
                put("b", 70);
            }
        };
        System.out.println(simpleAb(map4, 101));

        HashMap<String, Integer> map5 = new HashMap<>() {
            {
                put("c", 70);
                put("a", 10);
                put("b", 20);
            }
        };
        System.out.println(simpleAb(map5, 101));
    }

    public static String simpleAb(Map<String, Integer> abInfo, int abSum) {
        int randomV = ThreadLocalRandom.current().nextInt(0, abSum);
        System.out.println(randomV);

        NavigableMap<Integer, String> weightMap = new TreeMap<>();
        int sum = 0;

        // 构建累积权重映射
        for (Map.Entry<String, Integer> entry : abInfo.entrySet()) {
            sum += entry.getValue();
            weightMap.put(sum, entry.getKey());
        }

        // 使用随机数来获取命中的 abName
        return weightMap.ceilingEntry(randomV + 1).getValue();
    }
}
