package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_2504 {
    private static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        // 괄호의 값

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        int temp = 1, flag = 1;

        if(input.length() % 2 == 1) flag = 0;

        if(input.charAt(0) == '(') {
            stack.push(input.charAt(0));
            temp *= 2;
        } else if(input.charAt(0) == '[') {
            stack.push(input.charAt(0));
            temp *= 3;
        } else flag = 0;

        for(int i=1 ; i<input.length() ; i++) {
            if(flag == 0) break;

            Character c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                if(input.charAt(i-1) == '(')
                    result += temp;
                temp /= 2;

                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else {
                    flag = 0;
                    break;
                }
            } else if (c == ']') {
                if(input.charAt(i-1) == '[')
                    result += temp;
                temp /= 3;

                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else {
                    flag = 0;
                    break;
                }
            }
        }

//        System.out.println(stack + " " + flag);
        if(stack.isEmpty() && flag == 1) System.out.println(result);
        else System.out.println(0);
    }
}
