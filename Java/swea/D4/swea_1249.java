package swea.D4;

import java.io.*;
import java.util.*;

public class swea_1249 {
	// [S/W 문제해결 응용] 4일차 - 보급로
	// DFS -> 아마 시간초과
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ;i <=T ; i++) {
			init();
			DFS(new Point(0, 0), 0);
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		answer = Integer.MAX_VALUE;
		
		for(int i=0 ;i<N ; i++) {
			String str = br.readLine();
			for(int j=0 ;j<N ; j++ ) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
	}
	
	public static void DFS(Point point, int sum) {
		// basis part
		if(point.x == N-1 && point.y == N-1) {
			answer = Math.min(answer, sum);
			return ;
		}
		
		if(sum > answer) return ;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = point.x + dx[i];
			int ny = point.y + dy[i];
			
			if(checkRange(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				DFS(new Point(nx, ny), sum + map[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
