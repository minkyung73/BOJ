package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_4193 {
	// 수영대회 결승전 (완전 탐색 + 구현)
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	static int sx, sy, ex, ey;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<= T ; i++) {
			init();
			sb.append("#").append(i).append(" ").append(BFS()).append("\n");
		}
		System.out.println(sb);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
	}
	
	public static int BFS() {
		PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new Point(sx, sy, 0));
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			if(now.x == ex && now.y == ey) return now.cnt;
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
					// 토네이도인 경우와 아닌 경우
					if(map[nx][ny] == 2) {
						queue.offer(new Point(nx, ny, now.cnt + (3-now.cnt%3)));
						visited[nx][ny] = true;
					}
					else {
						queue.offer(new Point(nx, ny, now.cnt+1));
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
