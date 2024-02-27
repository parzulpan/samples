package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class daily145 {
    public static void main(String[] args) {

    }
}

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        postorder(root, ans);

        return ans;
    }

    private void postorder(TreeNode root, ArrayList<Integer> ans) {
        // 后序遍历
        if (root == null) {
            return;
        }

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
