package tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class daily106 {
    public static void main(String[] args) {

    }
}

class Solution106 {
    private int[] postorder;
    private Map<Integer, Integer> d = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 从中序和后序遍历序列构造二叉树
        // 后序序列的最后一个节点 postorder[j + n - 1] 为根节点，我们在中序序列中找到根节点的位置 k，
        // 可以将中序序列划分为左子树 inorder[0..k]、右子树 inorder[k+1..]。
        // 使用递归构建左右子树
        int n = postorder.length;
        this.postorder = postorder;
        for (int i = 0; i < n; i++) {
            d.put(inorder[i], i);
        }

        return dfs(0, 0, n);
    }

    private TreeNode dfs(int i, int j, int n) {
        if (n <= 0) {
            return null;
        }
        int v = postorder[j + n - 1];
        int k = d.get(v);
        TreeNode left = dfs(i, j, k - i);
        TreeNode right = dfs(k + 1, j + k - i, n - k + i - 1);

        return new TreeNode(v, left, right);
    }
}