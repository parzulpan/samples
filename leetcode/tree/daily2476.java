package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

/**
 * leetcode daily
 * 
 * @author parzulpan
 * @since 2024/02/24
 */
public class daily2476 {
    public static void main(String[] args) {

    }
}

class Solution2476 {
    private List<Integer> nums = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // 二叉搜索树，中序遍历得到一个有序数组
        dfs(root);

        List<List<Integer>> ans = new ArrayList<>();
        for (Integer x : queries) {
            // 二分查找
            // 如果找到了元素，则返回值是搜索键的索引；返回值会在 0 到 list.size() - 1 的范围内。
            // 如果没有找到元素，则返回值是 -(insertion point) - 1。
            // 插入点是键将要插入列表的那个点：即列表中第一个大于这个键的元素索引。如果列表中所有元素都小于该键，则插入点是 list.size()。
            int i = Collections.binarySearch(nums, x + 1);
            int j = Collections.binarySearch(nums, x);
            i = i < 0 ? -i - 2 : i - 1;
            j = j < 0 ? -j - 1 : j;
            int min = i >= 0 && i < nums.size() ? nums.get(i) : -1;
            int max = j >= 0 && j < nums.size() ? nums.get(j) : -1;
            ans.add(List.of(min, max));
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
