package boj.gold._5;

import java.io.*;
import java.util.*;

/**
 * DP
 */
public class boj_17070_2 {
	// 파이프 옮기기 1

	static int N;
	static int[][] map;
	static int[][][] dp;
	
	// 0:가로, 1:대각선, 2: 세로
	static final int[] dx = {0, 1, 1};
	static final int[] dy = {1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(DP());
//		print();
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1][3];
		
		for(int i=1 ; i<=N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1 ;j<=N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}		
	}
	
	public static void print() {
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ;j <=N ; j++)
				System.out.print("["+dp[i][j][0] + "," + dp[i][j][1]+"," + dp[i][j][2]+"]  ");
			System.out.println();
		}
	}
	
	public static int DP() {
		move(1, 2, 0);
		print();
		System.out.println("=======================");
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=3 ; j<=N ; j++) {
				for(int k=0 ; k<3 ; k++) {
					System.out.println(i + " " + j + " " + k);
					if(dp[i][j][k] != 0) {
						move(i, j, k);
						print();
					}
					System.out.println("=======================");
				}
			}
		}
		
		return dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
	}
	
	public static void move(int x, int y, int dir) {
		
		if(dir == 0) {
			for(int i=0 ; i<2 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(i == 1 ? checkRangeWithDir(nx, ny) : checkRange(nx, ny) 
						&& map[nx][ny] != 1) {
					
					dp[nx][ny][i]++;
				}
			}
		}
		else if(dir == 1) {
			for(int i=0 ; i<3 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(i == 1 ? checkRangeWithDir(nx, ny) : checkRange(nx, ny) 
						&& map[nx][ny] != 1) {
					
					dp[nx][ny][i]++;
				}
			}
		}
		else if(dir == 2) {
			for(int i=1 ; i<3 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(i == 1 ? checkRangeWithDir(nx, ny) : checkRange(nx, ny) 
						&& map[nx][ny] != 1) {
					
					dp[nx][ny][i]++;
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= N;
	}
	
	public static boolean checkRangeWithDir(int x, int y) {
		if(!checkRange(x-1, y) || !checkRange(x, y-1)) return false;
		if(map[x-1][y] == 1 || map[x][y-1] == 1) return false;
		return checkRange(x, y);
	}
}
