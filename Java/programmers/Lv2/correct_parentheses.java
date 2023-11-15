package programmers.Lv2;

import java.util.*;

// 올바른 괄호
class correct_parentheses {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();

        for(int i=0 ; i<s.length() ; i++) {
            if(s.charAt(i)=='(') stack.push("(");
            else if(s.charAt(i)==')') {
                if(!stack.isEmpty() && stack.contains("(")) {
                    stack.pop();
                }
                else {
                    answer = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}