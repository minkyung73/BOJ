package boj.gold._4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2580 {
	// 스도쿠
	static int[][] map, result;
	static List<Point> list;
	
	public static void main(String[] args) throws IOException {
		init();
		sdoku(0);
		print();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		result = new int[9][9];
		list = new ArrayList<>();
		
		for(int i=0 ; i<9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new Point(i, j));
			}
		}
	}

	public static void sdoku(int cnt) {
		// basis part
		if(cnt == list.size()) {
			copy();
			return ;
		}
		
		// inductive part
		boolean[] visited = new boolean[10];
		Point now = list.get(cnt);
		
		// 가로, 세로
		for(int i=0 ; i<9 ; i++) {
			visited[map[now.x][i]] = true;	// 가로
			visited[map[i][now.y]] = true; 	// 세로
		}
		
		// 사각형
		int mx = (now.x / 3) * 3 + 1;
		int my = (now.y / 3) * 3 + 1;
		visited[map[mx][my]] = true;
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i=0 ; i<8 ; i++) {
			int nx = mx + dx[i];
			int ny = my + dy[i];
			visited[map[nx][ny]] = true;
		}
		
		for(int i=1 ; i<=9 ; i++) {
			if(!visited[i]) {
				map[now.x][now.y] = i;
				sdoku(cnt+1);
				map[now.x][now.y] = 0;
			}
		}
	}
	
	public static void copy() {
		for(int i = 0 ; i<9 ; i++)
			result[i] = map[i].clone();
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++)
				sb.append(result[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
