package tree;

import java.util.ArrayList;
import java.util.List;

import common.Node;

public class daily590 {
    public static void main(String[] args) {

    }
}

class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        postorder(root, ans);

        return ans;
    }

    private void postorder(Node root, List<Integer> ans) {
        // N 叉树后序遍历
        if (root == null) {
            return;
        }
        for (Node children : root.children) {
            postorder(children, ans);
        }
        ans.add(root.val);
    }
}
