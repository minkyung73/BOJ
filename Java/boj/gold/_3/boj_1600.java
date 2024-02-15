package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600 {
	// 말이 되고픈 원숭이
	static int k;
	static int w, h;
	static int[][] map;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static final int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static final int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		BFS();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[w][h];
		
		for(int i=0 ; i<w ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<h ;j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[w][h][k];
	
		queue.offer(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && map[nx][ny] == 0) {
					
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
	
	public static class Node {
		int x, y, cnt, jump;

		public Node(int x, int y, int cnt, int jump) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}
	}
}
