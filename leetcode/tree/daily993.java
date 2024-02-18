package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.TreeNode;

public class daily993 {
    public static void main(String[] args) {
        Solution993 solution = new Solution993();

        // case1
        TreeNode root1 = TreeNode.buildTree(new Integer[] { 1, 2, 3, 4 });
        System.out.println(solution.isCousins(root1, 4, 3));

        // case2
        TreeNode root2 = TreeNode.buildTree(new Integer[] { 1, 2, 3, null, 4, null, 5 });
        System.out.println(solution.isCousins(root2, 5, 4));

        // case3
        TreeNode root3 = TreeNode.buildTree(new Integer[] { 1, 2, 3, null, 4 });
        System.out.println(solution.isCousins(root3, 2, 3));

    }
}

class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        // BFS
        List<TreeNode> q = List.of(root);
        while (!q.isEmpty()) {
            List<TreeNode> tN = new ArrayList<TreeNode>();
            HashMap<Integer, TreeNode> tVN = new HashMap<Integer, TreeNode>();
            for (TreeNode node : q) {
                if (node.left != null) {
                    tN.add(node.left);
                    tVN.put(node.left.val, node);
                }
                if (node.right != null) {
                    tN.add(node.right);
                    tVN.put(node.right.val, node);
                }

            }
            TreeNode xN = tVN.get(x);
            TreeNode yN = tVN.get(y);
            if (xN != null && yN != null && xN != yN) {
                return true;
            }

            tVN.clear();

            q = tN;
        }

        return false;
    }
}
