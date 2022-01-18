package com.dpf.test.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pikachues
 * Created 2022/1/6
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = num-1; i >0 ; i--) {
            int cnt = num/i;
            int remain = num%i;
            StringBuilder sb = new StringBuilder();
            String remainRes;
            while (cnt>0){
                if(cnt!=1){
                    sb.append(i+"*");
                }else{
                    if(remain!=0&&(i+remain)!=num){
                        StringBuilder sb2 = new StringBuilder(sb);
                        sb2.append(i+remain);
                        System.out.println(num+"="+sb2.toString());
                    }
                    sb.append(i);
                }
                cnt--;
            }
            sb.append("+"+remain);
            String s = sb.toString();
            System.out.println(num+"="+s);
        }

    }

}
