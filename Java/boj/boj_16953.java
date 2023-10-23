package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953 {
    // A -> B

    private static long A, B;
    private static int depth = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int result = BFS();
        System.out.println(result);
    }

    public static int BFS() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {
                long cur_num = queue.poll();

                if(cur_num == B) {
                    return depth;
                }

                long num1 = cur_num * 2;
                long num2 = Long.parseLong(cur_num + "1");

                if(num1 <= B) queue.add(num1);
                if(num2 <= B) queue.add(num2);
            }

            depth++;
        }

        return -1;
    }
}
