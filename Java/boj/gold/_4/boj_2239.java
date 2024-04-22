package boj.gold._4;

import java.io.*;
import java.util.Arrays;

public class boj_2239 {
	// 스도쿠
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[][] position;
	static int cnt = 0;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		init();
		sdoku(0);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int i=0 ; i<9 ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<9 ; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
				if(map[i][j] == 0) cnt++;
			}
		}
		
		position = new int[cnt][2];
		int idx = 0;
		for(int i=0 ; i<9 ; i++) {
			for(int j=0 ;j<9 ; j++) {
				if(map[i][j] == 0) {
					position[idx][0] = i;
					position[idx][1] = j;
					idx++;
				}
			}
		}
	}
	
	public static void sdoku(int depth) {
		// basis part
		if(flag) return ;
		
		if(depth == cnt) {
			flag = true;
			for(int i=0 ;i<9 ; i++) {
				for(int j=0 ; j<9 ;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return ;
		}
		
		// inductive part
		for(int i=1 ; i<=9 ; i++) {
			if(check(position[depth][0], position[depth][1], i)) {
				map[position[depth][0]][position[depth][1]] = i;
				sdoku(depth+1);
				map[position[depth][0]][position[depth][1]] = 0;
			}
		}
	}
	
	public static boolean check(int x, int y, int num) {	
		for(int i=0 ; i<9 ; i++) {
			if(map[x][i] == num) return false;
			if(map[i][y] == num) return false;
		}
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		int mx = (x / 3) * 3 + 1;
		int my = (y / 3) * 3 + 1;
		
		for(int i=0 ; i<8 ; i++) {
			int nx = mx + dx[i];
			int ny = my + dy[i];
			if(map[nx][ny] == num) return false;
		}
		
		return true;
	}
}
