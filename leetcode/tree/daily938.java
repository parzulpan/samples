package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * leetcode daily
 * 
 * @author parzulpan
 * @since 2024/02/25
 */
public class daily938 {
    public static void main(String[] args) {

    }
}

class Solution938 {
    private List<Integer> nums = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int low, int high) {
        // 二叉搜索树的范围和
        // 思路：先中序遍历，然后对遍历结果进行处理
        dfs(root);

        int ans = 0;
        for (Integer x : nums) {
            if (x >= low && x <= high) {
                ans += x;
            }
        }

        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }
}
