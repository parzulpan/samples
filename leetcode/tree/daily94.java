package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class daily94 {
    public static void main(String[] args) {
        Solution94 solution = new Solution94();

        // case1
        System.out.println(solution.inorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })));
        // case2
        System.out.println(solution.inorderTraversal(TreeNode.buildTree(new Integer[] { 1 })));

    }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root, ans);

        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        // 中序遍历
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
