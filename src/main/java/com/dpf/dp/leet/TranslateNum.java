package com.dpf.dp.leet;

/**
 * 把数字翻译成字符串
 * @author Pikachues
 * Created 2022/2/11
 */
public class TranslateNum {
    class Solution {
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int[] dp = new int[str.length()+1];
            dp[0]=1;
            dp[1]=1;
            // 12258
            for(int i=2;i<=str.length();i++){
                String tempStr = str.substring(i-2,i);
                if(tempStr.compareTo("10")>=0&&tempStr.compareTo("25")<=0){
                    dp[i] = dp[i-1]+dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }
            return dp[dp.length-1];
        }
    }
}
