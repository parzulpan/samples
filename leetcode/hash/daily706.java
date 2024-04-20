package hash;

import java.util.Arrays;

public class daily706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3)); // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2)); // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2)); // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}

/**
 * 设计哈希映射
 * 思路：要求不使用任何内建的哈希表库设计一个哈希映射（HashMap）。由于 0 <= key, value <= 10^6，所以可以直接用数组实现
 */
class MyHashMap {
    private int[] data = new int[1000001];

    public MyHashMap() {
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}
