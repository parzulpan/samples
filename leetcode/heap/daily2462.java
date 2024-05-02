package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class daily2462 {
    public static void main(String[] args) {

    }
}

class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        // 雇佣 K 位工人的总代价
        // 思路：优先队列(小根堆)
        // 1. 如果 candidates * 2 >= n，则说明不需要分 candidates，直接排序返回前 k 个最小工人代价之和
        // 2. 否则，使用小根堆 pq 来维护前 candidates 个工人和后 candidates 个工人的代价，pq 存入工人的代价和下标
        // 3. 用两个指针 left 和 right 分别指向前后待选工人的下标，初始时 left = candidates, right = n
        // -candidates - 1
        // 4. 进行 k 此循环，每次从 pq 选出代价最小的工人，
        // 4.1 如果 left > right 说明工人已被选完，
        // 4.2 如果当前工人的下标小于 left 说明是前面的工人，则将第 left 个工人的代价及下标加入 pq，然后left+1
        // 4.3 right 反之

        int n = costs.length;
        long ans = 0;

        if (candidates * 2 >= n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }

            return ans;
        }

        // 队列会首先根据数组的第一个元素进行排序，如果第一个元素相同，则根据第二个元素进行排序。
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[] { costs[i], i });
            pq.offer(new int[] { costs[n - i - 1], n - i - 1 });
        }
        int left = candidates, right = n - candidates - 1;
        while (k-- > 0) {
            int[] p = pq.poll();
            ans += p[0];
            if (left > right) {
                continue;
            }
            if (p[1] < left) {
                pq.offer(new int[] { costs[left], left++ });
            } else {
                pq.offer(new int[] { costs[right], right-- });
            }
        }

        return ans;
    }
}