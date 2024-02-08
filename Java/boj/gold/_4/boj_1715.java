package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1715 {
	// 카드 정렬하기
	static int n;
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(calc());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for(int i=0 ; i<n ; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
	}

	public static int calc() {
		int sum = 0;
		
		while(queue.size() > 1) {
			int temp = queue.poll() + queue.poll();
			queue.offer(temp);
			sum += temp;
		}
		
		return sum;
	}
}
