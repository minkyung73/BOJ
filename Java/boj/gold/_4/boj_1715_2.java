package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_1715_2 {
	// 카드 정렬하기
	static int n;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(calc());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
		for(int i=0 ; i<n ; i++) pq.offer(Integer.parseInt(br.readLine()));
	}
	
	public static int calc() {
		int sum = 0;
		
		while(pq.size() > 1) {
			int num = pq.poll() + pq.poll();
			sum += num;
			pq.offer(num);
		}
		
		return sum;
	}
}
