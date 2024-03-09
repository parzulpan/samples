package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import common.Pair;

public class daily2396 {
    public static void main(String[] args) {
        Solution2386 solution = new Solution2386();

        // case1
        System.out.println(solution.kSum(new int[] { 2, 4, -2 }, 5));
        // case2
        System.out.println(solution.kSum(new int[] { 1, -2, 3, 4, -10, 12 }, 16));
    }
}

class Solution2386 {
    public long kSum(int[] nums, int k) {
        // 找出数组的第 K 大和
        // 思路：优先队列（小根堆）
        // 1. 找到最大的子序和 mx，即所有正数之和
        // 2. 可以发现，其他子序列的和，都是在 mx 之上减去其他部分子序列之和得到，因此问题转换为求第 k 小的子序列和
        // 3. 先将所有数的绝对值升序排列，然后建立小根堆，存储二元组(s,i)，s 代表当前和，i 代表下一个待选择的数字的下标为 i 的子序列
        // 4. 每次取出堆顶，并放入两种情况：1. 再选择下一位；2. 选择下一位并且不选择本位；

        long mx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                mx += nums[i];
            } else {
                nums[i] *= -1;
            }
        }

        Arrays.sort(nums);
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.offer(new Pair<Long, Integer>(0L, 0));
        while (--k > 0) {
            Pair<Long, Integer> p = pq.poll();
            Long s = p.getKey();
            Integer i = p.getValue();
            if (i < n) {
                pq.offer(new Pair<Long, Integer>(s + nums[i], i + 1));
                if (i > 0) {
                    pq.offer(new Pair<Long, Integer>(s + nums[i] - nums[i - 1], i + 1));
                }
            }
        }

        return mx - pq.peek().getKey();
    }
}
