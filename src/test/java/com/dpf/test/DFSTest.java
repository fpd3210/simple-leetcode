package com.dpf.test;

import java.util.Arrays;

/**
 * @Author Pikachues
 * @Date 2021/12/19
 */
public class DFSTest {

    public static void main(String[] args) {
        int n = 5;
        ans = new int[n];
        book = new boolean[n];
        dfs(n,0);
    }

    static int[] ans;
    static boolean[] book;
    public static void dfs(int n,int step){
        if(step==n){
            System.out.println(Arrays.toString(ans));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!book[i]){
                ans[step] = i+1;
                book[i] = true;
                dfs(n,step+1);
                book[i] = false;
            }
        }
    }
}
