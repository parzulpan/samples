package _testjava;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetRetainAll {
    public static void main(String[] args) {
        // 创建Set A和Set B
        Set<String> setA = new ConcurrentSkipListSet<>();
        setA.add("apple");
        setA.add("banana");
        setA.add("cherry");

        System.out.println(setA);

        Set<String> setB = new ConcurrentSkipListSet<>();
        setB.add("banana");
        setB.add("cherry");
        setB.add("date");
        setB.add("fig");
        System.out.println(setB);

        setB.retainAll(setA);
        System.out.println(setA);
        System.out.println(setB);
    }
}
