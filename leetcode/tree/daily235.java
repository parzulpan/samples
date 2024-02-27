package tree;

import common.TreeNode;

/**
 * leetcode daily
 * 
 * @author parzulpan
 * @since 2024/02/25
 */
public class daily235 {
    public static void main(String[] args) {

    }
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树：左节点的值 < 根节点的值 < 右节点的值
        // 如果根节点的值大于这两个节点的最大值，说明其最近公共最先祖先在根节点的左子树。
        // 如果根节点的值小于这两个节点的最小值，说明其最近公共最先祖先在根节点的右子树。
        // 如果都不满足，即根节点的值为这两个节点的中间值，则其为最近公共最先祖先节点。
        if (root == null) {
            return null;
        }

        while (true) {
            if (root.val > Math.max(p.val, q.val)) {
                root = root.left;
            } else if (root.val < Math.min(p.val, q.val)) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
