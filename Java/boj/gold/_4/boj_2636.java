package boj.gold._4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2636 {
	// 치즈
	static int n, m;
	static int[][] map;
	static int totalCheese, nowCheese;
	static int hour;
	
	public static void main(String[] args) throws IOException{
		init();
		cheese();
		System.out.println(hour + "\n" + nowCheese);
	}
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		totalCheese = nowCheese = 0;
		hour = 0;
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<m ; j++	) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) totalCheese++;
			}
		}
	}

	public static void cheese() {
		while(totalCheese != 0) {
			nowCheese = totalCheese;
			BFS();
			hour++;
		}
	}
	
	public static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		queue.offer(new Point(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny]) {
					if(map[nx][ny] == 0) queue.offer(new Point(nx, ny));
					else {
						totalCheese--;
						map[nx][ny] = 0;
					}
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
