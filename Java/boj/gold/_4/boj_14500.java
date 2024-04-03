package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_14500 {
	// 테트로미노
	static int n, m;
	static int[][] map;
	static int answer;
	
	static final int[][][] pair = {
			{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, 
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, 
			{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, 
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}}, 
			{{0, 0}, {0, 1}, {0, 2}, {1, 0}}, 
			{{0, 0}, {0, 1}, {1, 1}, {2, 1}}, 
			{{0, 0}, {0, 1}, {0, 2}, {-1, 2}}, 
			{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, 
			{{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}, 
			{{0, 0}, {0, 1}, {0, 2}, {1, 1}}, 
			{{0, 0}, {-1, 1}, {0, 1}, {1, 1}}, 
			{{0, 0}, {0, 1}, {0, 2}, {-1, 1}}, 
			{{0, 0}, {1, 0}, {2, 0}, {1, 1}}, 
			{{0, 0}, {1, 0}, {2, 0}, {2, -1}}, 
			{{0, 0}, {0, 1}, {0, 2}, {1, 2}}, 
			{{0, 0}, {1, 0}, {2, 0}, {0, 1}}, 
			{{0, 0}, {1, 0}, {1, 1}, {1, 2}}, 
			{{0, 0}, {1, -1}, {1, 0}, {2, -1}}, 
			{{0, 0}, {0, 1}, {1, 1}, {1, 2}}
	};
	static final int[][][] checkPair = {
			{{0, 3}}, 
			{{3, 0}}, 
			{{1, 1}}, 
			{{2, 1}}, 
			{{0, 2}, {1, 0}}, 
			{{2, 1}}, 
			{{-1, 2}}, 
			{{2, 1}}, 
			{{-1, 2}}, 
			{{0, 2}, {1, 1}}, 
			{{-1, 1}, {1, 1}}, 
			{{0, 2}, {-1, 1}}, 
			{{2, 0}, {1, 1}}, 
			{{2, -1}}, 
			{{1, 2}}, 
			{{2, 0}, {0, 1}}, 
			{{1, 2}}, 
			{{2, -1}}, 
			{{1, 2}}
	};
	
	public static void main(String[] args) throws IOException {
		init();
		tetromino();
		System.out.println(answer);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		answer = 0;
		
		int nx = 0, ny = 0;
		
		for(int i=0 ; i<n ; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0 ; j<temp.length ; j++) {
				map[nx][ny] = Integer.parseInt(temp[j]);
				
				ny++;
				if(ny == m) {
					nx++;
					ny = 0;
				}
			}
		}
	}
	
	public static void tetromino() {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				K: for(int k=0 ; k<pair.length ; k++) {
					for (int k2 = 0; k2 < checkPair[k].length; k2++) {
						int x = i + checkPair[k][k2][0];
						int y = j + checkPair[k][k2][1];
						if(!checkRange(x, y)) continue K;
					}
					calc(i, j, pair[k]);
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public static void calc(int x, int y, int[][] pa) {
		int sum = 0;
		for(int i=0 ; i<4 ; i++) {
			int nx = x + pa[i][0];
			int ny = y + pa[i][1];
			sum += map[nx][ny];
		}
		answer = Math.max(answer, sum);
	}
}
