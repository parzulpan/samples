package _testjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class testset {
    public static void main(String[] args) {
        /**
         * start
         * exec 10000000
         * exec 10000000
         * end 1198 10000001
         */
        // run1();

        run2();
    }

    public static void run1() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < 10_000_000; i++) {
            set1.add(String.valueOf(i));
            set2.add(String.valueOf(10_000_000 - i));
        }
        ArrayList<Set<String>> setList = new ArrayList<>();
        setList.add(set1);
        setList.add(set2);

        System.out.println("start");
        long start = System.currentTimeMillis();
        Set<String> resultSet = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture.allOf(setList.stream().map(set -> CompletableFuture.runAsync(() -> {
            System.out.println("exec " + set.size());
            resultSet.addAll(set);
        })).toArray(CompletableFuture[]::new)).join();

        System.out.println("end " + (System.currentTimeMillis() - start) + " " + resultSet.size());
    }

    public static void run2() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < 10_000_000; i++) {
            set1.add(String.valueOf(i));
            set2.add(String.valueOf(10_000_000 + i));
        }
        ArrayList<Set<String>> setList = new ArrayList<>();
        setList.add(set1);
        setList.add(set2);

        System.out.println("start");
        long start = System.currentTimeMillis();
        Set<String> resultSet = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture.allOf(setList.stream().map(set -> CompletableFuture.runAsync(() -> {
            System.out.println("exec " + set.size());
            resultSet.addAll(set);
        })).toArray(CompletableFuture[]::new)).join();

        System.out.println("end " + (System.currentTimeMillis() - start) + " " + resultSet.size());
    }
}
