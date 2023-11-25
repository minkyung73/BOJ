package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_11286 {
    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) > Math.abs(o2)) return 1;
            else if(Math.abs(o1) < Math.abs(o2)) return -1;
            else {
                if(o1 > o2) return 1;
                else return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 절댓값 힙

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absQueue = new PriorityQueue<>(new CustomComparator());

        for(int i=0 ; i<n ; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input != 0) {
                absQueue.add(input);
            } else {
                if(!absQueue.isEmpty()) {
                    System.out.println(absQueue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }


    }
}
