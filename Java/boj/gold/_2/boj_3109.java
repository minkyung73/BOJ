package boj.gold._2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3109 {
	// 빵집
	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};

	public static void main(String[] args) throws IOException {
		init();
		pipe();
		System.out.println(cnt);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		cnt = 0;

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == '.') map[i][j] = 0;
				else map[i][j] = 1;
				
			}
		}
	}
	
	public static void pipe() {
		visited = new boolean[r][c];
		
		for(int i=0 ; i<r ; i++) {
			if(DFS(i, 0)) cnt++;
		}
	}
	
	public static boolean DFS(int rIdx, int cIdx) {
		// basis part
		if(cIdx == c-1) {
			return true;
		}
		
		// inductive part
		for(int i=0 ; i<3 ; i++) {
			int nx = rIdx + dx[i];
			int ny = cIdx + dy[i];
			
			if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
				
				visited[nx][ny] = true;
				if(DFS(nx, ny)) return true;
			}
		}
		
		return false;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
}
