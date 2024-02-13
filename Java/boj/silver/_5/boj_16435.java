package boj.silver._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16435 {
	// 스네이크버드
	static int n, l;
	static int[] h;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(snakeBird());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		h = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) h[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(h);
	}
	
	public static int snakeBird() {
		for(int i=0 ; i<n ; i++) {
			if(h[i] <= l) l++;
		}
		
		return l;
	}
}
