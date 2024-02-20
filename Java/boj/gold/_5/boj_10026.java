package boj.gold._5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {
	// 적록색약
	static StringBuilder sb;
	static int n;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		init();
		RGB(1);	// 적록색약 x
		reMap();
		RGB(2);	// 적록색약 o
		System.out.println(sb);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<n ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	}
	
	public static void reMap() {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
	}
	
	public static void RGB(int num) {
		int cnt = 0;
		visited = new boolean[n][n];
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(!visited[i][j]) {
					BFS(i, j, map[i][j], num);
					cnt++;
				}
			}
		}
		
		sb.append(cnt).append(" ");
	}
	
	public static void BFS(int x, int y, char color, int num) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(checkRange(nx, ny) && !visited[nx][ny]
						&& map[nx][ny] == color) {
					
					queue.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
