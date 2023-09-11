import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_11279 {
    public static void main(String[] args) throws IOException {
        // 최대 힙

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0 ; i < n ; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > 0) {
                maxQueue.add(input);
            } else {
                if(!maxQueue.isEmpty()) {
                    System.out.println(maxQueue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
