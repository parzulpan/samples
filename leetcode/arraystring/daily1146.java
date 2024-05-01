package arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class daily1146 {
    public static void main(String[] args) {

    }
}

/**
 * 快照数组
 * 思路：按题意即可
 * 1. 维护一个长度为 length 的数组，数组中的每个元素是一个列表，用来存储每次设置的值以及对应的快照 ID。
 * 
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
class SnapshotArray {
    private List<List<Integer>> arr;
    private int index;

    public SnapshotArray(int length) {
        arr = new ArrayList<List<Integer>>(length);
    }

    public void set(int index, int val) {
        List<Integer> t = new ArrayList<>() {
            {
                add(index);
                add(val);
            }
        };

        arr.get(index).add(t);

    }

    public int snap() {

    }

    public int get(int index, int snap_id) {

    }
}
