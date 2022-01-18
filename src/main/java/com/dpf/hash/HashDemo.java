package com.dpf.hash;


import java.util.*;

/**
 * Hash时间复杂度都是O(1)
 */
public class HashDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));

        Map<String,String> map = new HashMap<>();
        System.out.println(map.put("k1", "v1"));
        System.out.println(map.put("k1","v1"));


        //testTreeMap();
    }

    public static void testHashSet(){
        // 基本数据类型，内部按值传递，内存占用就是这个值的大小
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(4);

        System.out.println(set.contains(4));
        System.out.println(set.remove(1));
        System.out.println(set.contains(1));

        System.out.println("=======================");

        // 非基本数据类型，内部按引用传递，传递的是地址的值，内存占用是地址值的大小
        Set<Node> nodeSet = new HashSet<>();

        Node node1 = new Node(6);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        nodeSet.add(node1);
        nodeSet.add(node2);
        nodeSet.add(node3);
        nodeSet.add(node4);
        System.out.println(nodeSet.contains(node1));
        System.out.println(nodeSet.remove(node1));
        System.out.println(nodeSet.contains(node1));
    }

    public static void testHashMap(){
        Map<String,Object> map = new HashMap<>();

        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.put("k4","v4");
        map.put("k5","v5");
        map.put("k6","v6");

        System.out.println(map.containsKey("k1"));
        System.out.println(map.remove("k1"));
        System.out.println(map.containsValue("v1"));
        System.out.println(map.get("k2"));

        // todo java8方法

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        map.forEach((key,value)->{
            System.out.println(key+"---"+value);
        });
    }


    public static void testTreeSet(){
        // 基本类型
        Set<Integer> set = new TreeSet<>();
        set.add(8);
        set.add(2);
        set.add(1);
        set.add(6);
        for (Integer num:set){
            System.out.println(num);
        }
        System.out.println("=======================");
        // 非基本类型，有序
        Set<Node> nodeSet = new TreeSet<>(new NodeComparableSort());
        Node node1 = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        nodeSet.add(node1);
        nodeSet.add(node2);
        nodeSet.add(node3);
        nodeSet.add(node4);
        for (Node cur:nodeSet){
            System.out.println(cur.value);
        }
    }

    public static void testTreeMap(){
        Map<Node,String> nodeMap = new TreeMap<>(new NodeComparableSort());
        Node node1 = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        nodeMap.put(node1,"node1");
        nodeMap.put(node2,"node2");
        nodeMap.put(node3,"node3");
        nodeMap.put(node4,"node4");



        Set<Node> nodeSet = nodeMap.keySet();
        for (Node cur:nodeSet){
            System.out.println(cur.value+"--"+nodeMap.get(cur));
        }

    }

    public static class Node{
       public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class NodeComparableSort implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value-o2.value;
        }
    }


}
