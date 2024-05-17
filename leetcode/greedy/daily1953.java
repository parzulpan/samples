package greedy;

public class daily1953 {
    public static void main(String[] args) {

    }
}

class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        // 你可以工作的最大周数
        // 思路：贪心
        // 1. 如果存在一个项目 i，它的阶段任务数大于其余所有项目的阶段任务数之和再加 1，那么就不能完成所有阶段任务。
        // 否则，我们一定可以通过不同项目之间来回穿插的方式完成所有阶段任务。

        // 所有项目的阶段任务数之和
        long s = 0;
        // 最大的阶段任务数
        int mx = 0;
        for (int m : milestones) {
            s += m;
            mx = Math.max(mx, m);
        }

        long rest = s - mx;

        return mx > rest + 1 ? rest * 2 + 1 : s;
    }
}
