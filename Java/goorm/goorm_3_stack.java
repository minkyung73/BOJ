package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class goorm_3_stack {
    private static List<Integer> stack = new ArrayList<>();
    private static int n, k;

    private static void push(int n) {
        if(stack.size() < k) stack.add(n);
        else System.out.println("Overflow");
    }

    private static void pop() {
        if(!stack.isEmpty()) {
            System.out.println(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
        else System.out.println("Underflow");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String input = st2.nextToken();

            if(input.equals("push")) {
                int num = Integer.parseInt(st2.nextToken());
                push(num);
            } else pop();
        }
    }
}
