package swea.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5653 {
	// [모의 SW 역량테스트] 줄기세포배양
	
	static int n, m, k;
	static int[][] map;
	static boolean[][] visited;
	static int hour;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// n, m, k input
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			// initialize
			map = new int[n][m];
			visited = new boolean[n][m];
			hour = 0;
			
			// map input
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<m ; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			//
			
			
			// result
			sb.append("#").append(i).append(" ").append("res").append("\n");
		}
		
		System.out.println(sb);
	
	} // end of main

	// function definition
	public static void BFS(int x, int y) {
		
	}
	
	// function definition
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	// class definition
	public static class Node {
		int x;
		int y;
		int status;	// 0: 죽은 상태 / 1: 활성 상태 / 2: 비활성 상태
		int activeHour;
		
		public Node(int x, int y, int status, int activeHour) {
			this.x = x;
			this.y = y;
			this.status = status;
			this.activeHour = activeHour;
		}
	}
}
