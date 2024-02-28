package boj.silver._1;

import java.util.*;
import java.io.*;

public class boj_1010 {
	// 다리 놓기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] sel;
	static int result;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			init();
			combi(0, 0, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[N];
		result = 0;
	}

	public static void combi(int idx, int k, int cnt) {
		// basis part		
		if(k == N) {
			System.out.println(Arrays.toString(sel));
			result++;
			return ;
		}
		
		if(idx == M) return ;
		
		// inductive part
		for(int i=idx ; i<M ; i++) {
			sel[k] = i;
			combi(idx+1, k+1, cnt+1);
//			combi(idx, k+1, cnt);
		}
	}

}
