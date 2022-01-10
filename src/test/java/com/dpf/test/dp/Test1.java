package com.dpf.test.dp;

import java.util.Arrays;

/**
 * @author Pikachues
 * Created 2022/1/6
 */
public class Test1 {
    int getMinCoinCountOfValue(int total,int[] values,int valueIndex){
        int valueCount = values.length;
        if(valueIndex==valueCount){
            return Integer.MAX_VALUE;
        }
        int minResult = Integer.MAX_VALUE;

        int currentValue = values[valueIndex];
        int maxCount = total/currentValue;

        for (int count = maxCount; count >= 0 ; count--) {
            int rest = total - count*currentValue;

            if(rest==0){
                minResult = Math.min(minResult,count);
            }

            int restCount = getMinCoinCountOfValue(rest,values,valueIndex+1);

            if(restCount==Integer.MAX_VALUE){
                if(count==1){
                    break;
                }
                continue;
            }
            minResult = Math.min(minResult,count+restCount);
        }
        return minResult;
    }

    /**
     *
     * @param total 总价
     * @param values 银币面值
     * @param k 硬币枚数
     * @return
     */
    int getMinCoinCountLoop(int total,int[] values,int k){
        // 最小硬币枚数
        int minCount = Integer.MAX_VALUE;
        // 硬币枚数
        int valueCount = values.length;

        if(k==valueCount){
            return Math.min(minCount,getMinCoinCountOfValue(total,values,0));
        }

        for (int i = k; i < valueCount ; i++) {
            int temp = values[k];
            values[k] = values[i];
            values[i] = temp;

            minCount = Math.min(minCount,getMinCoinCountOfValue(total,values,k+1));

            temp = values[k];
            values[k] = values[i];
            values[i] = temp;
        }
        return minCount;
    }

    int getMinCoinCountOfValue(){
        int[] values = {5,3};
        int total = 11;
        int minCoin = getMinCoinCountLoop(total,values,0);

        return (minCoin==Integer.MAX_VALUE)?-1:minCoin;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
