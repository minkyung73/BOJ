package boj.gold._3;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class boj_1941 {
	// 소문난 칠공주
	static char[][] map = new char[5][5];
	static int[] sel = new int[7];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		init();
		combi(0, 0, 0);
		System.out.println(cnt);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0 ; i<5 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
	
	public static void combi(int idx, int k, int ynum) {
		// basis part
		if(ynum >= 4) return ;

		if(k == 7) {
//			System.out.println(Arrays.toString(sel));
			BFS();
			return ;
		}
		
		if(idx == 25) return ;
		
		// inductive part
		sel[k] = idx;
		if(map[idx/5][idx%5] == 'S') combi(idx+1, k+1, ynum);
		else combi(idx+1, k+1, ynum+1);
		combi(idx+1, k, ynum);
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[7];
		int connected = 1;
		
		queue.offer(new int[] {sel[0]/5, sel[0]%5});
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(!checkRange(nx, ny)) continue;
				
				for(int j=0 ;j<7 ; j++) {
					if(!visited[j] && sel[j] == nx*5+ny) {
						queue.offer(new int[] {nx, ny});
						visited[j] = true;
						connected++;
					}
				}
			}
		}
		
		if(connected == 7) cnt++;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < 5 && y >= 0 && y < 5;
	}
}
