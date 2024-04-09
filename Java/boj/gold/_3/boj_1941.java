package boj.gold._3;

import java.io.*;

public class boj_1941 {
	static char[][] map = new char[5][5];
	static boolean[][] visited;
	static int cnt = 0;
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		for(int i=0 ;i <5 ; i++) {
			for(int j=0 ;j <5 ; j++) {
				visited = new boolean[5][5];
				if(map[i][j] == 'Y') princess(0, i, j, 1, 0);
				else princess(0, i, j, 0, 1);
			}
		}
		System.out.println(cnt);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0 ;i<5 ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<5 ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	}
	
	public static void princess(int depth, int x, int y, int y_num, int s_num) {
		// basis part
		if(depth == 7) {
			cnt++;
			return ;
		}
		
		if(y_num >= 4) return ;
		
		// inductive part
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				if(map[nx][ny] == 'Y') princess(depth+1, nx, ny, y_num+1, s_num);
				else princess(depth+1, nx, ny, y_num, s_num+1);
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < 5 && y >= 0 && y < 5;
	}
}
