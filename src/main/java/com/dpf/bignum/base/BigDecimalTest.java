package com.dpf.bignum.base;

import java.math.BigDecimal;

/**
 * @author Pikachues
 * Created 2022/1/4
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1231.111111");
        BigDecimal b2 = new BigDecimal("3211111.222222");

        System.out.println(add(b1,b2));
        System.out.println(sub(b1,b2));
        System.out.println(mul(b1,b2));
        System.out.println(div(b2,b1));

        System.out.println(round(b1,3));

    }

    /**
     * 加法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2){
       return b1.add(b2);
    }

    /**
     * 减法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal sub(BigDecimal b1,BigDecimal b2){
        return b1.subtract(b2);
    }

    /**
     * 乘法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal mul(BigDecimal b1,BigDecimal b2){
        return b1.multiply(b2);
    }

    /**
     * BigDecimal.ROUND_HALF_UP 舍入模式：四舍五入
     * 除法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal div(BigDecimal b1,BigDecimal b2){
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入
     * @param b1
     * @param len 保留几位
     * @return
     */
    public static BigDecimal round(BigDecimal b1,int len){
       return b1.divide(new BigDecimal(1),len,BigDecimal.ROUND_HALF_UP);
    }

}
