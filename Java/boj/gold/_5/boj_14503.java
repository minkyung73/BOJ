package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
	// 로봇 청소기 
	static int n, m;
	static int r, c, d;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(clean());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static int clean() {
		int cnt = 0;
		
		/**
		 * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
		 * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
		 * 	2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
		 * 	2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
		 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		 * 	3-1. 반시계 방향으로 90도 회전한다.
		 * 	3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
		 */
		while(true) {
			// 1
			if(map[r][c] == 0) {
				map[r][c] = 2;
				cnt++;
			}
			// 2
			if(isCleaned(r, c)) {
				if(checkBackward()) backward();	// 2-1
				else break;	// 2-2
			}
			// 3
			else {	
				rotate();	// 3-1
				forward();	// 3-2
			}
		}
		
		return cnt;
	}
	
	public static boolean isCleaned(int x, int y) {
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) && map[nx][ny] == 0) 
				return false;
		}
		return true;
	}
	
	public static boolean checkRange(int x, int y) {
		return x > 0 && x < n-1 && y > 0 && y < m-1;
	}

	// 후진 가능한지
	public static boolean checkBackward() {
		// 북, 동, 남, 서
		if(d == 0 && ((r+1 == n-1) || map[r+1][c] == 1)) return false;
		if(d == 1 && ((c-1 == 0) || map[r][c-1] == 1)) return false;
		if(d == 2 && ((r-1 == 0) || map[r-1][c] == 1)) return false;
		if(d == 3 && ((c+1 == m-1) || map[r][c+1] == 1)) return false;
		
		return true;
	}
	
	// 후진
	public static void backward() {
		if(d == 0) r++;
		if(d == 1) c--;
		if(d == 2) r--;
		if(d == 3) c++;
	}

	// 회전
	public static void rotate() {
		d = d > 0 ? d - 1 : 3;	
	}

	// 전진
	public static void forward() {
		int nx = r + dx[d];
		int ny = c + dy[d];
		
		if(checkRange(nx, ny) && map[nx][ny] == 0) {
			if(d == 0) r--;
			if(d == 1) c++;
			if(d == 2) r++;
			if(d == 3) c--;
		}
	}
}
