package common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // 用于跟踪前序遍历的位置
    private static int index = 0;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] preorder) {
        // 每次调用buildTree时重置index
        index = 0;
        return buildTreeHelper(preorder);
    }

    private static TreeNode buildTreeHelper(Integer[] preorder) {
        // 如果全部节点已经处理完，或者当前节点是空节点
        if (index >= preorder.length || preorder[index] == null) {
            index++; // 移动到下一个节点
            return null;
        }

        // 创建当前节点
        TreeNode root = new TreeNode(preorder[index++]);
        // 递归创建左子树和右子树
        root.left = buildTreeHelper(preorder);
        root.right = buildTreeHelper(preorder);

        return root;
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + ", " + (left != null ? "left=" + left + ", " : "")
                + (right != null ? "right=" + right : "") + "]";
    }

}
