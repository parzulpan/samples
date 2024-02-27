package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

public class daily103 {
    public static void main(String[] args) {

    }
}

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            ArrayList<Integer> tV = new ArrayList<Integer>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode tN = q.poll();
                tV.add(tN.val);

                if (tN.left != null) {
                    q.offer(tN.left);
                }
                if (tN.right != null) {
                    q.offer(tN.right);
                }
            }

            if (depth % 2 == 0) {
                Collections.reverse(tV);
                ans.add(tV);
            } else {
                ans.add(tV);
            }
            depth++;
        }

        return ans;
    }
}