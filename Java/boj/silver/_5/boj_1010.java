package boj.silver._5;

import java.util.*;
import java.io.*;

public class boj_1010 {
	// 다리 놓기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] sel;
	static boolean[] visited;
	static int result;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			init();
			sb.append(dp(N, M)).append("\n");
//			print();
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
	}
	
	public static int dp(int n, int m) {
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=i ; j<=i + M-N ; j++) {
				if(i==j) arr[i][j] = 1;
				else if(i==1) arr[i][j] = j;
				else arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
			}
		}
		
		return arr[n][m];
	}

	public static void print() {
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
