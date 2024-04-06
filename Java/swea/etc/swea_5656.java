package swea.etc;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class swea_5656 {
	// [모의 SW 역량테스트] 벽돌 깨기
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n, w, h;
	static int[][] map, copy;
	static int[] sel;
	static int answer;
	static int initMarbleCnt;
	static int tempMarbleCnt;
	
	// 상 하 좌 우
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=1 ; i<= t ; i++) {
			init();
			permutation(0);
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		sel = new int[n];
		answer = Integer.MAX_VALUE;
		initMarbleCnt = 0;
		
		for(int i=0 ; i<h ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<w ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) initMarbleCnt++;
			}
		}
	}
	
	public static void permutation(int idx) {
		// basis part
		if(idx == n) {
			shoot();
			return ;
		}
		
		// inductive part
		for(int i=0 ; i<w ; i++) {
			sel[idx] = i;
			permutation(idx+1);
		}
	}
	
	public static void shoot() {
		// map copy
		copy = new int[h][w];
		for(int i=0 ; i<h ; i++) copy[i] = map[i].clone();
		
		// initialize tempMarbleCnt
		tempMarbleCnt = initMarbleCnt;
		
		for(int i=0 ; i<n ; i++) {
			Point point = find_location(sel[i]);
			if(point == null) continue;
			bomb(point.x, point.y);
			drop();
		}

		answer = Math.min(answer, tempMarbleCnt);
	}
	
	public static Point find_location(int idx) {
		for(int i=0 ; i<h ; i++) {
			if(copy[i][idx] != 0) 
				return new Point(i, idx);
		}
		return null;
	}
	
	public static void bomb(int x, int y) {
		int num = copy[x][y];
		
		// 자기 자신 터뜨리기
		copy[x][y] = 0;
		tempMarbleCnt--;
		
		// 주변 터뜨리기
		for(int i=1 ; i<=num-1 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				int nx = x + dx[j]*i;
				int ny = y + dy[j]*i;
				
				if(checkRange(nx, ny) && copy[nx][ny] != 0) {
					bomb(nx, ny);
				}
			}
		}	
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}
	
	public static void drop() {
		for(int i=0 ; i<w ; i++) {	
			int start = -1;
			int end = -1;

			for(int j=h-1 ; j>=0 ; j--) {
				if(copy[j][i] == 0) {
					start = j;
					end = j-1;
					break;
				}
			}
			
			if(end == -1) continue;
			
			while(end >= 0) {
				if(copy[end][i] == 0) end--;
				else {
					copy[start][i] = copy[end][i];
					copy[end][i] = 0;
					start--;
					end--;
				} 
			}
		}
	}
	
	public static void print(int[][] arr) {
		for(int i=0 ; i<h ; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
