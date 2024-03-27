package boj.gold._3;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1520 {
	// 내리막길
	
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		init();
//		DFS(1, 1);
		System.out.println(DFS(1, 1));
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		
		for(int i=1 ; i<=n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<=m ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
	}
	
	public static int DFS(int x, int y) {
		if(x == n && y == m) return 1;
		if(dp[x][y] != -1) return dp[x][y];
		
		dp[x][y] = 0;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) 
					&& map[nx][ny] < map[x][y]) {
				dp[x][y] += DFS(nx, ny);
			}
		}
		
		return dp[x][y];
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 1 && x <=n && y >= 1 && y <= m;
	}
}
