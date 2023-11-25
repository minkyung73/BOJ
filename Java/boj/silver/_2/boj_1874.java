package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();       // 1 ~ n
        Stack<Integer> result = new Stack<>();      // 수열 넣는 List
        List<String> output = new ArrayList<>();    // + - 출력

        int push_num = 1;
        int idx = 0;
        int cnt = 1;
        int flag = 1;

        while (result.size() < n) {

            // 뽑으려는 숫자가 없으면 stack push
            if(stack.isEmpty() || arr[idx] != stack.peek()) {
                stack.push(push_num++);
                output.add("+");
            }

            // top에 뽑으려는 숫자가 있으면 stack pop
            if(stack.peek() == arr[idx]) {
                result.push(stack.pop());
                output.add("-");
                idx++;
            } // stack에 뽑으려는 숫자는 있지만 arr에 더 큰 수들이 남아있는 경우
            else if(stack.contains(arr[idx])) {
                for(int i = idx+1 ; i<n ; i++) {
                    if(arr[i] > arr[idx]) {
                        flag = 2;
                        break;
                    }
                }
            }

            if(flag == 2) {
                flag = 0;
                break;
            }

        }

        if(flag == 0) System.out.println("NO");
        else {
            for (String r : output)
                System.out.println(r);
        }

    }
}
