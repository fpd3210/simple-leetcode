package com.dpf.sort.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 比较器、排序接口测试
 * Comparable为比较器接口，当实体类没有实现Comparable，在需要排序(Array.sort,Collections.sort....)时可以通过传入Comparator进行定制排序
 */
public class TestComparator {

    /**
     * 实现Comparable接口，支持排序的类
     *
     */
    public static class Student implements Comparable<Student>{

        public int number;
        public int age;
        public String name;

        public Student(int number,  String name,int age) {
            this.number = number;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
/*
           if(this.age<o.age){
               return -1;
           }
           if(this.age>o.age){
               return 1;
           }else {
               return 0;
           }
*/
//            return this.age-o.age;

            //多条件排序
            if(this.age!=o.age){
                return this.age-o.age;
            }else {
                return this.number-o.number;
            }


        }

        @Override
        public String toString() {
            return "Student{" +
                    "number=" + number +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Student2{
        public int number;
        public int age;
        public String name;

        public Student2(int number,  String name,int age) {
            this.number = number;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "number=" + number +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }




    /**
     * 测试类实现了排序接口
     */
    public static void testContainsSort(){
        ArrayList<Student> list = new ArrayList<>();
        Student student1 = new Student(3, "zs1", 18);
        Student student2 =  new Student(2,"zs2",18);
        Student student3 =  new Student(4,"zs3",23);
        Student student4 = new Student(5,"zs4",19);

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.forEach(System.out::println);
        System.out.println();
        Collections.sort(list);

        list.forEach(System.out::println);
    }

    /**
     * 类没有实现排序接口，通过比较器进行排序
     */
    public static void testNoContainsSort(){
        ArrayList<Student2> list = new ArrayList<>();
        Student2 student1 = new Student2(3, "zs1", 18);
        Student2 student2 =  new Student2(2,"zs2",18);
        Student2 student3 =  new Student2(4,"zs3",23);
        Student2 student4 = new Student2(5,"zs4",19);

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.forEach(System.out::println);
        System.out.println();
        Collections.sort(list, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.age-o2.age;
            }
        });

        list.forEach(System.out::println);
    }



    public static void main(String[] args) {

        testNoContainsSort();
    }
}
