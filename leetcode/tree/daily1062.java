package tree;

import common.TreeNode;

public class daily1062 {
    public static void main(String[] args) {

    }
}

class Solution1062 {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        // 节点与其祖先之间的最大差值
        // 思路：DFS

        dfs(root, root.val, root.val);

        return ans;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        int x = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        ans = Math.max(ans, x);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
