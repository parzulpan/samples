package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class daily894 {
    public static void main(String[] args) {

    }
}

class Solution894 {
    private List<TreeNode>[] f;

    public List<TreeNode> allPossibleFBT(int n) {
        // 所有可能的真二叉树
        // 思路：记忆化搜索

        f = new List[n + 1];

        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (f[n] != null) {
            return f[n];
        }
        // n = 1
        if (n == 1) {
            return List.of(new TreeNode());
        }

        // n > 1
        List<TreeNode> ans = new ArrayList<TreeNode>();
        for (int i = 0; i < n - 1; i++) {
            int j = n - 1 - i;
            for (TreeNode left : dfs((i))) {
                for (TreeNode right : dfs(j)) {
                    ans.add(new TreeNode(0, left, right));
                }
            }
        }

        return f[n] = ans;
    }
}
