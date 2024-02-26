package boj.bronze._3;
import java.io.*;
import java.util.*;

public class boj_20361 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, X, K;
	static boolean[] candy;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(findCandy());
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		candy = new boolean[N+1];
		candy[X] = true;
	
		for(int i=0 ;i <K ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			swap(a, b);
		}
	}

	private static void swap(int a, int b) {
		boolean temp = candy[a];
		candy[a] = candy[b];
		candy[b] = temp;
	}

	public static int findCandy() {
		for(int i=1 ; i<=N ; i++) {
			if(candy[i]) return i;
		}
		
		return -1;
	}
}
