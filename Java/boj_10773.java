import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class boj_10773 {
    // 제로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<k ; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(temp != 0) stack.push(temp);
            else stack.pop();
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();
        System.out.println(sum);
    }
}
