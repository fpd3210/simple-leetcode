package com.dpf.dfs.leet;


import java.util.*;

/**
 * 字符串的全排列
 *
 * @author Pikachues
 * Created 2022/2/9
 */
public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] aabs = solution.permutation("aab");
        System.out.println(Arrays.toString(aabs));

    }

    static class Solution {
        public String[] permutation(String s) {
            List<List<String>> res = new ArrayList<>();
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            dfs(res, new ArrayList<>(), chs, new boolean[chs.length]);
            String[] resStr = new String[res.size()];
            int index = 0;
            for (List<String> re : res) {
                String resTemp = "";
                for (String str : re) {
                    resTemp+=str;
                }

                resStr[index++] = resTemp;
            }
            return resStr;
        }

        public void dfs(List<List<String>> res, List<String> temp, char[] chs, boolean[] visited) {
            if (temp.size() == chs.length) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < chs.length; i++) {
                if (i > 0 && chs[i] == chs[i - 1] && visited[i - 1]) {
                    continue;
                }
                if (!visited[i]) {
                    temp.add(chs[i] + "");
                    visited[i] = true;
                    dfs(res, temp, chs, visited);
                    visited[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
