package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.Node;

public class daily429 {
    public static void main(String[] args) {

    }
}

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Deque<Node> q = new ArrayDeque<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> tV = new ArrayList<Integer>();

            for (int i = q.size(); i > 0; i--) {
                Node tN = q.poll();
                tV.add(tN.val);
                q.addAll(tN.children);
            }

            ans.add(tV);
        }

        return ans;
    }
}
