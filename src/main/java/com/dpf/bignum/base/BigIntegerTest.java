package com.dpf.bignum.base;

import java.math.BigInteger;

/**
 * @author Pikachues
 * Created 2022/1/4
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789");
        BigInteger bi2 = new BigInteger("987654321");

        System.out.println("加法："+bi2.add(bi1));
        System.out.println("减法："+bi2.subtract(bi1));
        System.out.println("乘法："+bi2.multiply(bi1));
        System.out.println("除法："+bi2.divide(bi1));
        System.out.println("最大数："+bi2.max(bi1));
        System.out.println("最小数："+bi2.min(bi1));
        BigInteger[] result = bi2.divideAndRemainder(bi1);
        System.out.println("商是：" + result[0] + "；余数是：" + result[1]) ;
        System.out.println(bi1.compareTo(bi2));
    }
}
