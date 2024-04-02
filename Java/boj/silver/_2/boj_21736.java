package boj.silver._2;

import java.io.*;
import java.util.*;

public class boj_21736 {
	// 헌내기는 친구가 필요해
	static int n, m;
	static char[][] map;
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static Point doyeon;
	
	public static void main(String[] args) throws IOException {
		init();
		int res = BFS();
		System.out.println(res == 0 ? "TT" : res);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
	
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<m ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') doyeon = new Point(i, j);
			}
		}
	}
	
	public static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		queue.offer(doyeon);
		visited[doyeon.x][doyeon.y] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 'X') {
					queue.offer(new Point(nx, ny));
					visited[nx][ny] = true;
					if(map[nx][ny] == 'P') cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
