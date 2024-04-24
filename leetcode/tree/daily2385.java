package tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class daily2385 {
    public static void main(String[] args) {

    }
}

class Solution2385 {
    private TreeNode startNode;
    private final Map<TreeNode, TreeNode> fa = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        // 感染二叉树需要的总时间
        // 思路：DFS
        // 1. 先找到 start 节点
        // 2. 从 start 节点开衫 dfs，找到二叉树的最大深度

        dfs(root, null, start);

        return maxDepth(startNode, startNode);
    }

    private void dfs(TreeNode node, TreeNode from, int start) {
        if (node == null) {
            return;
        }

        // 记录每个节点的父节点
        fa.put(node, from);

        // 找到 start
        if (node.val == start) {
            startNode = node;
        }

        dfs(node.left, node, start);
        dfs(node.right, node, start);
    }

    private int maxDepth(TreeNode node, TreeNode from) {
        // start 的 深度为 0，所以这里返回 -1
        if (node == null) {
            return -1;
        }

        int res = -1;
        if (node.left != from) {
            res = Math.max(res, maxDepth(node.left, node));
        }
        if (node.right != from) {
            res = Math.max(res, maxDepth(node.right, node));
        }
        if (fa.get(node) != from) {
            res = Math.max(res, maxDepth(fa.get(node), node));
        }

        return res + 1;
    }
}
