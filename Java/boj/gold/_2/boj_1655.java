package boj.gold._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1655 {
	// 가운데를 말해요
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) maxHeap.offer(temp);
			else minHeap.offer(temp);
			
			swap();
			System.out.println(maxHeap + " " + minHeap);
			
			sb.append(maxHeap.peek() + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void swap() {
		if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
			if(minHeap.peek() < maxHeap.peek()) {
				int temp = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(temp);
			}
		}
	}
}
