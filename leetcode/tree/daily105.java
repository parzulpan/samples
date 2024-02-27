package tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class daily105 {
    public static void main(String[] args) {

    }
}

class Solution105 {
    private int[] preorder;
    private Map<Integer, Integer> d = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 从前序和中序遍历序列构造二叉树
        // 前序序列的第一个节点 preorder[i] 为根节点，我们在中序序列中找到根节点的位置 k，
        // 可以将中序序列划分为左子树 inorder[0..k]、右子树 inorder[k+1..]。
        // 使用递归构建左右子树
        int n = preorder.length;
        this.preorder = preorder;
        for (int i = 0; i < n; i++) {
            d.put(inorder[i], i);
        }

        return dfs(0, 0, n);
    }

    private TreeNode dfs(int i, int j, int n) {
        if (n <= 0) {
            return null;
        }
        int v = preorder[i];
        int k = d.get(v);
        TreeNode left = dfs(i + 1, j, k - j);
        TreeNode right = dfs(i + 1 + k - j, k + 1, n - 1 - (k - j));

        return new TreeNode(v, left, right);
    }
}
