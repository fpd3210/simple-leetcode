package com.dpf.dp.leet;

/**
 * 使用最小花费爬楼梯
 * @author Pikachues
 * Created 2022/1/6
 */
public class MinCostClimbingStairs {
    class Solution{
        public int minCostClimbingStairs(int[] cost) {
            int length = cost.length;
            int[] minCost = new int[length+1];
            for (int i = 2; i < length+1; i++) {
                minCost[i] = Math.min(minCost[i-1]+cost[i-1],minCost[i-2]+cost[i-2]);
            }
            return minCost[length];
        }
    }
}
