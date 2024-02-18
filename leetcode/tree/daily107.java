package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

public class daily107 {
    public static void main(String[] args) {

    }
}

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
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

            ans.add(tV);
        }

        Collections.reverse(ans);

        return ans;
    }
}
