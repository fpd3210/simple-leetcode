package com.dpf.dp.leet;

/**
 * 整数拆分
 * @author Pikachues
 * Created 2022/1/12
 */
public class IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int max = 1;
            for(int i = n-1;i>1;i--){
                int cnt = n/i;
                int remain = n%i;
                int sum = 1;
                while(cnt>0){
                    sum*=i;
                    cnt--;
                }
                if(remain!=0){
                    max = Math.max(sum*remain,max);
                    if(remain+i!=n){
                        max = Math.max((sum/i)*(remain+i),max);
                    }
                }else{
                    max = Math.max(max,sum);
                }
            }
            return max;
        }


        public int integerBreak2(int n) {
            int[] dp = new int[n+1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                int curMax = 0;
                for (int j = 1; j < i; j++) {
                    curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
                }
            }
            return dp[n];
        }
    }
}
