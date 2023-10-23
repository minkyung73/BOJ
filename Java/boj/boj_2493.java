package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> idx = new Stack<>();
    private static int flag = 0;

    private static void push(int n, int i) {

    }

    private static void pop() {
        stack.pop();
    }

    public static void main(String[] args) throws IOException {
        // 탑

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // stack
        int max_idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int target = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && target >= stack.peek()) {
                stack.pop();
                idx.pop();
            }

            if(stack.isEmpty()) System.out.print(0 + " ");
            else System.out.print((idx.peek()+1) + " ");

            stack.push(target);
            idx.push(i);
        }

    }
}
