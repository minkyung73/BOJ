package boj.silver._1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {
	// 쉬운 최단거리
	static int n, m;
	static int[][] map, result;
	static boolean[][] visited;
	static Point start;
	
	public static void main(String[] args) throws IOException{
		init();
		BFS();
		print();
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0 ;i <n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) start = new Point(i, j);
			}
		}
	}

	public static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		queue.offer(new Node(start.x, start.y, 0));
		visited[start.x][start.y] = true;
		result[start.x][start.y] = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(int i=0 ;i <4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new Node(nx, ny, now.cnt+1));
					visited[nx][ny] = true;
					result[nx][ny] = now.cnt+1;
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x>=0 && x<n && y >= 0 && y <m;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i <n ; i++) {
			for(int j=0 ;j<m ; j++) {
				if(map[i][j] == 1 && result[i][j] == 0) sb.append(-1).append(" ");
				else sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
