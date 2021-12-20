package com.dpf.stack.leet;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 */
public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            if(s.length()%2==0){
                Deque<Character> stack = new LinkedList<>();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(c=='('||c=='{'||c=='['){
                        stack.push(c);
                    }
                    else if(c==')'){
                        if(!stack.isEmpty()&&stack.peek()=='('){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
                    else if(c=='}'){
                        if(!stack.isEmpty()&&stack.peek()=='{'){
                            stack.pop();
                        }else {
                            return false;
                        }
                    } else{
                        if(!stack.isEmpty()&&stack.peek()=='['){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
                }
                return stack.isEmpty();
            }
            return false;
        }

        public boolean isValid2(String s) {
            if(s.length()%2==0){
                return false;
            }

            Map<Character,Character> pairs = new HashMap<Character,Character>(){{
                put(')','(');
                put('}','{');
                put(']','[');
            }};
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(pairs.containsKey(c)){
                    // 如果是右括号，看是否有匹配的左括号
                    if(stack.isEmpty()||stack.peek()!=pairs.get(c)){
                        return false;
                    }
                    stack.pop();
                }else {
                    // 如果时左括号，入栈
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}
