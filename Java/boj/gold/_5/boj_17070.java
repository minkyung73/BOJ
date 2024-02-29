package boj.gold._5;

import java.io.*;
import java.util.*;

/**
 * BFS => 시간초과 
 */
public class boj_17070 {
	// 파이프 옮기기 1
	
	static int N;
	static int[][] map;
	
	// 0:가로, 1:대각선, 2: 세로
	static final int[] dx = {0, 1, 1};
	static final int[] dy = {1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static int BFS() {
		int cnt = 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 1, 0));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.x == N-1 && now.y == N-1) {
				cnt++;
				continue;
			}
			
			if(now.dir == 0) {	// 가로
				for(int i=0 ; i<=1 ; i++) {	// 가로, 대각선 이동
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(checkRange(nx, ny, i) && map[nx][ny] != 1) {
						queue.offer(new Node(nx, ny, i));
					}
				}
			} 
			else if(now.dir == 1) {	// 대각선
				for(int i=0 ; i<=2 ; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(checkRange(nx, ny, i) && map[nx][ny] != 1) {
						queue.offer(new Node(nx, ny, i));
					}
				}
			} 
			else if(now.dir == 2) {	// 세로
				for(int i=1 ; i<=2 ; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(checkRange(nx, ny, i) && map[nx][ny] != 1) {
						queue.offer(new Node(nx, ny, i));
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean checkRange(int x, int y, int dir) {
		if(dir == 1) {
			if(x-1 < 0 || x-1 >= N || y < 0 || y >= N) return false;
			if(x < 0 || x >= N || y-1 < 0 || y-1 >= N) return false;
			if(map[x-1][y] == 1 || map[x][y-1] == 1) return false;
		}
		
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
