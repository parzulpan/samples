package tree;

import java.util.ArrayList;
import java.util.List;

import common.Node;

public class daily589 {
    public static void main(String[] args) {

    }
}

class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorder(root, ans);

        return ans;
    }

    private void preorder(Node root, List<Integer> ans) {
        // N 叉树前序遍历
        if (root == null) {
            return;
        }

        ans.add(root.val);
        for (Node children : root.children) {
            preorder(children, ans);
        }
    }
}
