package com.dpf.dp.base;

/**
 * 背包问题
 *
 * @author Pikachues
 * Created 2022/7/11
 */
public class PackageQuestion {


    /**
     * https://mp.weixin.qq.com/s/xmgK7SrTnFIM3Owpk-emmg
     * 0 1背包问题
     *
     * @param itemValue  每个东西的价值
     * @param itemWeight 每个东西的重量
     * @param maxWeight  背包容量
     * @return
     */
    public int zeroOnePackage(int[] itemValue, int[] itemWeight, int maxWeight) {
        int len = itemValue.length;
        // 一个二维数组，其中一维代表当前「当前枚举到哪件物品」，
        // 另外一维「现在的剩余容量」，数组装的是「最大价值」
        int[][] dp = new int[len][maxWeight + 1];

        // 考虑一件物品的情况(物品用数组存储，数组下标从0开始)
        for (int j = 0; j <= maxWeight; j++) {
            // 剩余容量 >= 当前物品容量可取(当背包容量<当前物品容量，装不下，所以价值为0)
            dp[0][j] = j >= itemWeight[0] ? itemValue[0] : 0;
        }

        // 再处理「考虑其余物品」的情况
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // 不选择该物品的最大价值
                int n = dp[i - 1][j];
                // 选择该物品，前提「剩余容量」大于等于「物品体积」时的最大价值
                int y = j >= itemWeight[i] ? dp[i - 1][j - itemWeight[i]] + itemValue[i] : 0;
                // 计算选择或不选择当前物品哪个价值最大
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[len - 1][maxWeight];
    }

    /*****************************************************************************************/

    /**
     * 完全背包问题
     *
     * @param itemValue
     * @param itemWeight
     * @param maxWeight
     * @return
     */
    public int absolutePackage(int[] itemValue, int[] itemWeight, int maxWeight) {
        int len = itemValue.length;
        int[][] dp = new int[len][maxWeight + 1];

        // 考虑一件物品的情况
        for (int j = 0; j <= maxWeight; j++) {
            int k = j / itemWeight[0];
            dp[0][j] = k * itemWeight[0];
        }

        // 考虑其他物品的情况
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                int n = dp[i - 1][j];
                int y = 0;
                for (int k = 1; ; k++) {
                    if (j < k * itemWeight[i]) {
                        break;
                    }
                    y = Math.max(y, dp[i - 1][j - k * itemWeight[i]] + k * itemValue[i]);
                }
                dp[i][j] = Math.max(y, n);
            }
        }

        return dp[len - 1][maxWeight];
    }

}
