package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class goorm_3_back_of_the_head {
    // 스택 - 뒤통수가 따가워
    private static int n;
    private static int[] arr;

    private static int[] stack;
    private static int top = 0;

    private static void push(int n) {
        stack[top++] = n;
    }

    private static int pop(int n) {
        int init_top = top;

        for (int i = init_top-1 ; i>= 0 ; i--) {
            if(top <= 0) return 0;
            if(stack[i] <= n) top--;
            else break;
        }

        return init_top;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        stack = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i< n ; i++) {
            if(!st.hasMoreTokens()) break;
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<n ; i++) {
            int cnt = pop(arr[i]);
            System.out.print(cnt + " ");
            push(arr[i]);
        }
    }
}
