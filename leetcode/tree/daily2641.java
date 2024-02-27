package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class daily2641 {
    public static void main(String[] args) {
        Solution2641 solution = new Solution2641();

        // case1
        TreeNode root1 = TreeNode.buildTree(new Integer[] { 5, 4, 9, 1, 10, null, 7 });
        System.out.println(solution.replaceValueInTree(root1));
        // case2
        TreeNode root2 = TreeNode.buildTree(new Integer[] { 3, 1, 2 });
        System.out.println(solution.replaceValueInTree(root2));

    }
}

class Solution2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        // BFS
        root.val = 0;
        List<TreeNode> q = List.of(root);
        while (!q.isEmpty()) {
            List<TreeNode> t = new ArrayList<TreeNode>();
            int s = 0;
            for (TreeNode node : q) {
                if (node.left != null) {
                    t.add(node.left);
                    s += node.left.val;
                }
                if (node.right != null) {
                    t.add(node.right);
                    s += node.right.val;
                }
            }
            for (TreeNode node : q) {
                int sub = (node.left == null ? 0 : node.left.val) +
                        (node.right == null ? 0 : node.right.val);
                if (node.left != null) {
                    node.left.val = s - sub;
                }
                if (node.right != null) {
                    node.right.val = s - sub;
                }
            }
            q = t;
        }

        return root;
    }
}