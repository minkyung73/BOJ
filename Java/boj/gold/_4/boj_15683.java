package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683 {
	// 감시
	static int n, m;
	static int[][] map;
	static List<CCTV> cctvList;
	static int[][][] dirCCTV;
	static int blindSpot;
	static int maxBlindSpot;
	
	public static void main(String[] args) throws IOException {
		init();
		cctv(0, 0);
		System.out.println(blindSpot);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		cctvList = new ArrayList<>();
		maxBlindSpot = blindSpot = n*m;
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6)
					cctvList.add(new CCTV(i, j));
				
				if(map[i][j] > 0) maxBlindSpot--;
			}
		}
		
		// cctv 가 감시할 수 있는 방향 
		// 1 2 3 4 <=> 동 서 남 북
		dirCCTV = new int[][][] {
				{}, 
				{{1}, {2}, {3}, {4}}, 
				{{1, 2}, {3, 4}}, 
				{{1, 3}, {1, 4}, {2, 3}, {2, 4}},
				{{1, 2, 4}, {1, 2, 3}, {2, 3, 4}, {1, 3, 4}}, 
				{{1, 2, 3, 4}}
		};
		
	}
	
	public static void cctv(int idx, int sum) {
		// basis part
		if(idx == cctvList.size()) {
			blindSpot = Math.min(blindSpot, maxBlindSpot-sum);
			return ;
		}
		
		// inductive part
		CCTV cctv = cctvList.get(idx);
		int type = map[cctv.x][cctv.y];

		for(int i=0 ; i<dirCCTV[type].length ; i++) {
			int cnt = 0;
			
			for(int j=0 ; j<dirCCTV[type][i].length ; j++)
				cnt += watch(cctv.x, cctv.y, dirCCTV[type][i][j]);
			
			cctv(idx+1, sum + cnt);	// function call
			
			for(int j=0 ; j<dirCCTV[type][i].length ; j++)
				nonWatch(cctv.x, cctv.y, dirCCTV[type][i][j]);
		}
	}

	private static int watch(int x, int y, int dir) {
		int cnt = 0;
		
		if(dir == 1) {
			for(int i=y+1 ; i<m ; i++) {
				if(map[x][i] == 6) break;
				
				if(map[x][i] <= 0) {
					map[x][i] --;
					if (map[x][i] == -1) cnt++;
				}
			}
		}
		else if(dir == 2) {
			for(int i = y-1 ; i>=0 ; i--) {
				if(map[x][i] == 6) break;
				
				if(map[x][i] <= 0) {
					map[x][i] --;
					if (map[x][i] == -1) cnt++;
				}
			}
		}
		else if(dir == 3) {
			for(int i=x+1 ; i<n ; i++) {
				if(map[i][y] == 6) break;
				
				if(map[i][y] <= 0) {
					map[i][y] --;
					if (map[i][y] == -1) cnt++;
				}
			}
		}
		else if(dir == 4) {
			for(int i=x-1 ; i>=0 ; i--) {
				if(map[i][y] == 6) break;
				
				if(map[i][y] <= 0) {
					map[i][y] --;
					if (map[i][y] == -1) cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static void nonWatch(int x, int y, int dir) {
		if(dir == 1) {
			for(int i=y+1 ; i<m ; i++) {
				if(map[x][i] == 6) break;
				if(map[x][i] < 0) map[x][i]++;
			}
		}
		else if(dir == 2) {
			for(int i=y-1 ; i>=0 ; i--) {
				if(map[x][i] == 6) break;
				if(map[x][i] < 0) map[x][i]++;
			}
		}
		else if(dir == 3) {
			for(int i=x+1 ; i<n ; i++) {
				if(map[i][y] == 6) break;
				if(map[i][y] < 0) map[i][y]++;
			}
		}
		else if(dir == 4) {
			for(int i=x-1 ; i>=0 ; i--) {
				if(map[i][y] == 6) break;
				if(map[i][y] < 0) map[i][y]++;
			}
		}
	}

	public static class CCTV {
		int x, y;

		public CCTV(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
