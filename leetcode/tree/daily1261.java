package tree;

import java.util.HashSet;
import java.util.Set;

import common.TreeNode;

public class daily1261 {
    public static void main(String[] args) {
        // case1
        TreeNode root1 = TreeNode.buildTree(new Integer[] { -1, -1, -1, -1, -1 });
        FindElements obj1 = new FindElements(root1);
        System.out.println(obj1.find(1));
        System.out.println(obj1.find(3));
        System.out.println(obj1.find(5));

        // case2
        TreeNode root2 = TreeNode.buildTree(new Integer[] { -1, null, -1, -1, null, -1 });
        FindElements obj2 = new FindElements(root2);
        System.out.println(obj2.find(2));
        System.out.println(obj2.find(3));
        System.out.println(obj2.find(4));
        System.out.println(obj2.find(5));
    }
}

/**
 * 在受污染的二叉树中查找元素
 * 思路：模拟+DFS
 */
class FindElements {
    private Set<Integer> nodes = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public boolean find(int target) {

        return nodes.contains(target);
    }

    private void dfs(TreeNode root, int pV) {
        if (root == null) {
            return;
        }

        nodes.add(pV);

        dfs(root.left, 2 * pV + 1);
        dfs(root.right, 2 * pV + 2);
    }
}
