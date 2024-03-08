package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2015 {
	// 수들의 합 4
	static int N, K;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		init();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int j=0 ;j<N ; j++) {
				
			}
		}
		
	}

}
