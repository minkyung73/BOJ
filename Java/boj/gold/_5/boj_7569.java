package boj.gold._5;

import java.io.*;
import java.util.*;

public class boj_7569 {
	// 토마토
	static int m, n, h;
	static int[][][] map;
	static Queue<Point> tomatoes;
	
	static final int[] dx = {-1, 1, 0, 0, 0, 0};
	static final int[] dy = {0, 0, -1, 1, 0, 0};
	static final int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		int result = BFS();
		System.out.println(!check_1() ? -1 : result);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n][m];
		tomatoes = new LinkedList<>();
	
		for(int i=0 ; i<h ; i++) {
			for(int j=0 ;j<n ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0 ; k<m ; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) tomatoes.offer(new Point(i, j, k, 0));
				}
			}
		}
	}
	
	public static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[h][n][m];
		int maxCnt = 0;
		
		while(!tomatoes.isEmpty()) {
			Point tomato = tomatoes.poll();
			queue.offer(tomato);
			visited[tomato.x][tomato.y][tomato.z] = true;
		}
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			maxCnt = Math.max(maxCnt, now.cnt);
			
			for(int i=0 ; i<6 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];
				
				if(checkRange(nx, ny, nz) && !visited[nx][ny][nz] && map[nx][ny][nz] == 0) {
					queue.offer(new Point(nx, ny, nz, now.cnt+1));
					visited[nx][ny][nz] = true;
					map[nx][ny][nz] = 1;
				}
			}
		}
		
		return maxCnt;
	}
	
	public static boolean checkRange(int x, int y, int z) {
		return x >= 0 && x < h && y >= 0 && y < n && z >= 0 && z < m;
	}
	
	public static boolean check_1() {
		for(int i=0 ; i<h ; i++) {
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<m ; k++) {
					if(map[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
	
	public static class Point {
		int x, y, z, cnt;

		public Point(int x, int y, int z, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}
}
