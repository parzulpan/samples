package fs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class daily721 {
    public static void main(String[] args) {

    }
}

class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 账户合并
        // 思路：哈希+DFS

        // 把 accounts 中的信息提取到哈希表 emailToIdx 中，key 为邮箱地址，value 为这个邮箱对应的账户下标列表。
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int k = 1; k < accounts.get(i).size(); k++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(k), x -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>(); // 用于收集 DFS 中访问到的邮箱地址
        for (int i = 0; i < accounts.size(); i++) {
            if (vis[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, vis, emailSet);

            List<String> res = new ArrayList<>(emailSet);
            Collections.sort(res);
            res.add(0, accounts.get(i).get(0));

            ans.add(res);
        }
        return ans;
    }

    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis,
            Set<String> emailSet) {
        vis[i] = true;
        for (int k = 1; k < accounts.get(i).size(); k++) { // 遍历 i 的所有邮箱地址
            String email = accounts.get(i).get(k);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (int j : emailToIdx.get(email)) { // 遍历所有包含该邮箱地址的账户下标 j
                if (!vis[j]) { // j 没有访问过
                    dfs(j, accounts, emailToIdx, vis, emailSet);
                }
            }
        }
    }
}
