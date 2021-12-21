package com.dpf.test;

/**
 * @author Pikachues
 * Created 2021/12/21
 */
public class StringTest {
    public static void main(String[] args) {
        testCharChangeToInt();
    }

    /**
     * char转int
     */
    public static void testCharChangeToInt(){
        String s = "123";
        char c = s.charAt(0);
        // method1
        int num = c - '0';
        System.out.println(num);
        // method2
        int num2 = Integer.parseInt(String.valueOf(c));
        System.out.println(num2);
        // method3
        Integer.parseInt(c+"");
    }
}
