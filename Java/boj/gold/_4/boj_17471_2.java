package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17471_2 {
	// 게더맨더링
	static int N;
	static int[] population;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		init();
		powerSet(1, 1, new boolean[N+1]);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		map = new int[N+1][N+1];
		
		// 각 구역의 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N ; i++) 
			population[i] = Integer.parseInt(st.nextToken());
		
		// 인접한 구역 연결하기
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			for(int j=0 ; j<num ; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][v] = map[v][i] = 1;
			}
		}
	}

	public static void powerSet(int idx, int k, boolean[] sel) {
		// basis part
		if(idx == N+1) {
			return ;
		}
		
		// inductive part
		sel[idx] = true;
		powerSet(idx+1, k+1, sel);
		sel[idx] = false;
		powerSet(idx+1, k, sel);
	}
	
}
