package com.dpf.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pikachues
 * Created 2022/2/11
 */
public class FindContinuousSequence {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> list = new ArrayList<>();
            int maxNum = target/2+1;
            int start = maxNum;
            while (start>0){
                int curStart = start;
                List<Integer> temp = new ArrayList<>();
                int sum = 0;
                while(true){
                    temp.add(curStart);
                    sum+=curStart;
                    curStart--;
                    if(sum==target){
                        list.add(temp);
                        break;
                    }
                    if(sum>target||curStart<1){
                        break;
                    }
                }
                start--;
            }

            int[][] res = new int[list.size()][];


            for(int i=list.size()-1;i>=0;i--){ // 1 0
                List<Integer> temp = list.get(i);
                Integer[] temArr = temp.toArray(new Integer[0]);
                res[list.size()-i-1] = new int[temArr.length];
                for (int j = temArr.length-1; j >=0 ; j--) { // 2
                    res[list.size()-i-1][temp.size()-j-1] = temArr[j];
                }
            }
            return res;
        }


        public int[][] findContinuousSequence2(int target) {
            List<List<Integer>> list = new ArrayList<>();
            int maxNum = target/2+1;

            int start = 1;
            while (start<=maxNum){

                int curStart = start;
                List<Integer> temp = new ArrayList<>();
                int sum = 0;
                while(true){
                    temp.add(curStart);
                    sum+=curStart;
                    curStart++;
                    if(sum==target){
                        list.add(temp);
                        break;
                    }
                    if(sum>target||curStart>maxNum){
                        break;
                    }
                }
                start++;
            }
            System.out.println(list.size());
            int[][] res = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                List<Integer> temp = list.get(i);
                res[i] = new int[temp.size()];
                for (int j = 0; j < temp.size(); j++) {
                    res[i][j] = temp.get(j);
                }
            }
            return res;
        }
    }
}
