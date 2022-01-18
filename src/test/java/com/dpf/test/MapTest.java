package com.dpf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Pikachues
 * @Date 2021/12/19
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"1");
        String res = "";
        for(Map.Entry<Integer,String> entity:map.entrySet()){
            for(int i=0;i<entity.getKey();i++){
                res+=entity.getValue();
            }
        }
        System.out.println(res);


    }


    /**
     * 测试getOrDefault
     */
    public static void testGetOrDefault(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("2","2");
        // 如果map中有这个key，就使用这个key的值，如果没有就使用defaultValue
        System.out.println(map.getOrDefault("1", 1));

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (Map.Entry<Character, Character> entry:pairs.entrySet()){

        }

        Set<Map.Entry<Character, Character>> entries = pairs.entrySet();


        pairs.forEach((k,v)-> System.out.println(k+"-"+v));
    }
}
