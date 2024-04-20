package lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class daily39 {
    public static void main(String[] args) {

    }
}

class Solution39 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 组合总和
        // 思路：排序 + 剪枝 + 回溯
        // 1. 先对数组进行排序，方便剪枝
        // 2. 设计一个函数 dfs(i,s)，表示从下标 i 开始搜索，且剩余目标值为 s，其中 i 和 s 都是非负整数，当前搜索路径为 t，答案为 ans。
        // 3. 进行递归，递归结束后，将当前下标的元素从搜索路径 t 中移除。

        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);

        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            ans.add(new ArrayList<>(t));
            return;
        }

        if (s < this.candidates[i]) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            t.add(candidates[j]);
            dfs(j, s - candidates[j]);
            t.remove(t.size() - 1);
        }
    }
}
