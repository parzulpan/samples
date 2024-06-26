package common;

/**
 * 自定义二元组
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair() {

    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
