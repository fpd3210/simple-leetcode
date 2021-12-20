package com.dpf.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Pikachues
 * @Date 2021/12/19
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("2","2");
        // 如果map中有这个key，就使用这个key的值，如果没有就使用defaultValue
        System.out.println(map.getOrDefault("1", 1));

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        pairs.forEach((k,v)-> System.out.println(k+"-"+v));

    }
}
