package woj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class woj_2005 {
    private static int n;
    private static Stack<Integer> stack = new Stack<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0 ; i<n ; i++) {
            if(arr[i] == 0){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(arr[i]);
        }

        long sum = 0;
        while (!stack.isEmpty()) {
            sum += Long.valueOf(stack.pop());
        }
        System.out.println(sum);
    }
}
