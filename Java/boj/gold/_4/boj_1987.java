package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_1987 {
	// 알파벳
	static int R, C;
	static int[][] map;
	static boolean[] visited;
	static int maxCnt;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		DFS(0, 0, 1);
		System.out.println(maxCnt);
//		System.out.println(Arrays.toString(visited));
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		map = new int[R][C];
		visited = new boolean[26];
		maxCnt = 0;
		
		for(int i=0 ; i<R ; i++) {
			String str = br.readLine();
			for(int j=0 ;j<C ; j++) {
				map[i][j] = str.charAt(j)-65;
			}
		}
	}
	
	public static void DFS(int x, int y, int depth) {
		visited[map[x][y]] = true;
		maxCnt = Math.max(maxCnt, depth);
		
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) && !visited[map[nx][ny]]) {
				DFS(nx, ny, depth+1);
				visited[map[nx][ny]] = false;
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
