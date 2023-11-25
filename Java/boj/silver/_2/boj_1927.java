package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1927 {
    public static void main(String[] args) throws IOException {
        // 최소 힙

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > 0) {
                minQueue.add(input);
            } else {
                if(!minQueue.isEmpty()) {
                    System.out.println(minQueue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
