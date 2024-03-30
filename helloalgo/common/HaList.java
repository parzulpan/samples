package common;

import java.util.Arrays;

/**
 * Ha 列表
 */
public class HaList {
    /**
     * 数组（存储列表元素）
     */
    private int[] arr;
    /**
     * 列表容量
     */
    private int capacity = 10;
    /**
     * 列表长度
     */
    private int size = 0;
    /**
     * 每次列表扩容的倍数
     */
    private int extendRatio = 2;

    public HaList() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        return arr[index];
    }

    public void set(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        arr[index] = num;
    }

    public void add(int num) {
        if (size == capacity()) {
            extendCapacity();
        }
        arr[size] = num;
        size++;
    }

    public void insert(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (size == capacity()) {
            extendCapacity();
        }
        for (int i = size - 1; i > index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = num;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int num = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

        return num;
    }

    public void extendCapacity() {
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        capacity = arr.length;
    }

    public int[] toArray() {
        int size = size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }

        return arr;
    }
}
