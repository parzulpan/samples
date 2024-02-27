package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class daily144 {
    public static void main(String[] args) {
        Solution144 solution = new Solution144();

        // case1
        System.out.println(solution.preorderTraversal(TreeNode.buildTree(new Integer[] { 1, null, 2, 3 })));
        // case2
        System.out.println(solution.preorderTraversal(TreeNode.buildTree(new Integer[] { 1 })));

    }
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorder(root, ans);

        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        // 前序遍历
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

}
