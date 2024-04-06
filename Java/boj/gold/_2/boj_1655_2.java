package boj.gold._2;

import java.io.*;
import java.util.*;

public class boj_1655_2 {
	// 가운데를 말해요
	static int n;
	static PriorityQueue<Integer> maxHeap, minHeap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
		maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		
		for(int i=0 ; i<n ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
			else minHeap.offer(num);
			
			swap();
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void swap() {
		if(minHeap.isEmpty() || maxHeap.isEmpty()) return ;
		
		if(minHeap.peek() < maxHeap.peek()) {
			int max = maxHeap.poll();
			int min = minHeap.poll();
			minHeap.offer(max);
			maxHeap.offer(min);
		}
	}
}
