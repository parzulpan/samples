package tree;

import common.TreeNode;

public class daily1379 {
    public static void main(String[] args) {

    }
}

class Solution1379 {
    private TreeNode target;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 找出克隆二叉树中的相同节点
        // 思路：DFS

        this.target = target;

        return dfs(original, cloned);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        TreeNode res = dfs(original.left, cloned.left);

        return res == null ? dfs(original.right, cloned.right) : res;
    }
}
