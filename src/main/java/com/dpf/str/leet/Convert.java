package com.dpf.str.leet;

/**
 * Z字型转换
 * @author Pikachues
 * Created 2022/3/1
 */
public class Convert {
    class Solution{
        public String convert(String s, int numRows) {
            if(numRows==1){
                return s;
            }

            StringBuilder[] sb = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                sb[i] = new StringBuilder();
            }

            int index = 0;
            int row = 0;
            while (index<s.length()){
                while (row<numRows&&index<s.length()){
                    sb[row++].append(s.charAt(index++));
                }
                if(index==s.length()){
                    break;
                }
                row -= 2;
                while (row>=0&&index<s.length()){
                    sb[row--].append(s.charAt(index++));
                }
                row+=2;
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                res.append(sb[i]);
            }


            return res.toString();
        }
    }
}
