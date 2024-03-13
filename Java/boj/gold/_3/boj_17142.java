package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17142 {
	// 연구소 3
	
	static int n, m;
	static int[][] map;
	static List<Virus> virusList;
	static Virus[] sel;
	static int result;

	public static void main(String[] args) throws IOException{
		init();
		combination(0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][n];
		virusList = new ArrayList<>();
		sel = new Virus[m];
		result = Integer.MAX_VALUE;
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virusList.add(new Virus(i, j, 0));
			}
		}
	}
	
	public static void combination(int idx, int k) {
		// basis part
		if(k == m) {
			System.out.println(Arrays.toString(sel));
			BFS(sel);
			return ;
		}
		
		if(idx == virusList.size()) return ;
		
		// inductive part
		sel[k] = virusList.get(idx);
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	
	public static void BFS(Virus[] activeVirus) {
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt = 0;
		
		for(int i=0 ; i<m ; i++) {
			queue.add(activeVirus[i]);
			visited[activeVirus[i].x][activeVirus[i].y] = true;
		}
		
		//
		while(!queue.isEmpty() && !checkAllVirus(visited)) {
			Virus now = queue.poll();
			cnt = Math.max(cnt, now.t);
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
					queue.offer(new Virus(nx, ny, now.t+1));
					visited[nx][ny] = true;
				}
			}
		}
		
		// 
		if(checkAllVirus(visited)) 
			result = Math.min(result, cnt);
	}
	
	public static boolean checkAllVirus(boolean[][] visited) {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ;j<n ;j++) {
				if(map[i][j] == 0 && !visited[i][j]) 
					return false;
			}
		}
		return true;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	public static class Virus {
		int x, y, t;

		public Virus(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", t=" + t + "]";
		}
	}
}
