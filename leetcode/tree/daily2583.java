package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import common.TreeNode;

public class daily2583 {
    public static void main(String[] args) {

    }
}

class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // bfs 后 sort 取值
        List<Long> ans = new ArrayList<Long>();
        Deque<TreeNode> d = new ArrayDeque<TreeNode>();
        d.offer(root);
        while (!d.isEmpty()) {
            long hV = 0;
            for (int i = d.size(); i > 0; i--) {
                TreeNode tN = d.poll();
                hV += tN.val;
                if (tN.left != null) {
                    d.offer(tN.left);
                }
                if (tN.right != null) {
                    d.offer(tN.right);
                }
            }
            ans.add(hV);
        }

        if (ans.size() <= k - 1) {
            return -1;
        }

        Collections.sort(ans, (o1, o2) -> o2.compareTo(o1));

        return ans.get(k - 1);
    }
}
