package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class daily331 {
    public static void main(String[] args) {

    }
}

class Solution331 {
    public boolean isValidSerialization(String preorder) {
        // 验证二叉树的前序序列化
        // 思路：用栈消消乐
        // 1. 理解到两个连续的#消掉一个叶子节点
        // 2. 如果遇到了连续两个 '#'，并且第三个元素不是 '#'，那么就将这三个元素替换成一个 '#'，这个过程一直持续到数组遍历结束
        // 3. 最后，判断数组长度是否为 111，且数组唯一的元素是否为 '#' 即可

        List<String> ans = new ArrayList<String>();
        for (String s : preorder.split(",")) {
            ans.add(s);
            while (ans.size() >= 3 &&
                    Objects.equals(ans.get(ans.size() - 1), "#") &&
                    Objects.equals(ans.get(ans.size() - 2), "#") &&
                    !Objects.equals(ans.get(ans.size() - 3), "#")) {
                ans.remove(ans.size() - 1);
                ans.remove(ans.size() - 1);
                ans.remove(ans.size() - 1);
                ans.add("#");
            }
        }

        return ans.size() == 1 && Objects.equals(ans.get(0), "#");
    }
}
