package com.dpf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pikachues
 * Created 2022/1/2
 */
public class ZTest {


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();

        dfs(0,nums,res,new ArrayList<>());
        for (List<Integer> temp:res){
            System.out.println(temp.toString());
        }
    }

    public static void dfs(int start,int[] nums,List<List<Integer>> res,List<Integer> temp ){
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(start+1,nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
