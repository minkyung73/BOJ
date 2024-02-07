package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16987 {
	// 계란으로로 계란치기
	static int n;
	static Queue<Egg> list = new LinkedList<>();
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n input
		n = Integer.parseInt(br.readLine());
		
		// egg input
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.offer(new Egg(p, w));
		}
		
		//
		for(int i=0 ; i<n ; i++) {
			list.offer(list.poll());
		}
	}
	
	public static void breakEgg() {
		
	}
	
	public static class Egg	 {
		int power;
		int weight;
		
		public Egg(int power, int weight) {
			this.power = power;
			this.weight = weight;
		}
	}
}
