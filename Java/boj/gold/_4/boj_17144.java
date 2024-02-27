package boj.gold._4;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class boj_17144 {
	private static final String List = null;
	// 미세먼지 안녕
	
	static int R, C, T;
	static int[][] map;
	static List<Point> cleaner;
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i=0 ; i<T ; i++) {
			diffuse();
			clean();
		}
		
		System.out.println(countDust());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new int[R][C];
		cleaner = new ArrayList<>();
		
		for(int i=0 ;i <R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j <C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleaner.add(new Point(i, j));
			}
		}
	}
	
	public static void diffuse() {
		List<Node> list = new ArrayList<>();
		
		// 미세 먼지가 있는 위치
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ;j<C ; j++) {
				if(map[i][j] > 0) {
					list.add(new Node(i, j, map[i][j]));
					map[i][j] = 0;
				}
			}
		}
		
		// 미세먼지 확산
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (Node node : list) {
			int cnt = 0;
			
			for(int i=0 ; i<4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(checkRange(nx, ny) && map[nx][ny] != -1) {
					map[nx][ny] += node.dust/5;
					cnt++;
				}
			}
			
			map[node.x][node.y] += node.dust - (node.dust/5)*cnt;
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
	
	public static void clean() {
		Point cl;

		// 공기 청정기 윗 부분 (반시계 방향)
		cl = cleaner.get(0);
		
		for(int i=cl.x-2 ; i>=0 ;i--)
			map[i+1][0] = map[i][0];
		
		for(int i=1 ; i<C ; i++)
			map[0][i-1] = map[0][i];
		
		for(int i=1 ; i<=cl.x ; i++)
			map[i-1][C-1] = map[i][C-1];
		
		for(int i=C-2 ; i>=1 ; i--)
			map[cl.x][i+1] = map[cl.x][i];
		map[cl.x][1] = 0;
		
		// 공기 청정기 아랫 부분 (시계 방향)
		cl = cleaner.get(1);
		
		for(int i=cl.x + 2 ; i<R ; i++)
			map[i-1][0] = map[i][0];
		
		for(int i=1 ; i<C ; i++)
			map[R-1][i-1] = map[R-1][i];
		
		for(int i=R-2 ; i>=cl.x ; i--) 
			map[i+1][C-1] = map[i][C-1];
		
		for(int i=C-2 ; i>=1 ; i--)
			map[cl.x][i+1] = map[cl.x][i];
		map[cl.x][1] = 0;
		
	}
	
	public static int countDust() {
		int sum = 0;
		
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				if(map[i][j] > 0) sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	public static class Node {
		int x, y, dust;

		public Node(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
