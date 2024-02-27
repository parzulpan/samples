package greedy;

import java.util.PriorityQueue;

public class dailylcp30 {
    public static void main(String[] args) {
        Solutionlcp30 solution = new Solutionlcp30();

        // case1
        System.out.println(solution.magicTower(new int[] { 100, 100, 100, -250, -60, -140, -50, -50, 100, 150 }));
        // case2
        System.out.println(solution.magicTower(new int[] { -200, -300, 400, 0 }));

    }
}

class Solutionlcp30 {
    public int magicTower(int[] nums) {
        // 解法：贪心 + 优先队列（小根堆）
        // 1. 优先队列（小根堆），存储怪物房间的血量减少值，堆顶元素为最小的负数
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        // 2. 当前血量
        long blood = 1;
        // 3. 当前待减少的血量
        long tmp = 0;
        // 4. 操作次数
        int ans = 0;
        for (int num : nums) {
            // 入堆
            if (num < 0) {
                q.offer(num);
            }
            // 计算血量
            blood += num;
            // 如果要挂了，则贪心的移动房间到末尾，然后记录待减少的血量，并把血加回来
            if (blood <= 0) {
                ++ans;
                tmp += q.peek();
                blood += -q.poll();
            }
        }
        // 处理待减少的血量
        blood += tmp;

        return blood <= 0 ? -1 : ans;
    }
}
