package tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class daily889 {
    public static void main(String[] args) {

    }
}

class Solution889 {
    private int[] preorder;
    private Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 889. 根据前序和后序遍历构造二叉树
        // 二叉树的根节点一定是前序遍历的第一个节点，也是后序遍历的最后一个节点。

        this.preorder = preorder;
        for (int i = 0; i < postorder.length; i++) {
            pos.put(postorder[i], i);
        }

        return dfs(0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int a, int b, int c, int d) {
        if (a > b) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[a]);
        if (a == b) {
            return root;
        }
        int i = pos.get(preorder[a + 1]);
        int m = i - c + 1;
        root.left = dfs(a + 1, a + m, c, i);
        root.right = dfs(a + m + 1, b, i + 1, d - 1);

        return root;
    }
}
