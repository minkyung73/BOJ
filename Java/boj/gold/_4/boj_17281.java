package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_17281 {
	// 야구
	
	static int N;
	static int[][] players;
	
	public static void main(String[] args) throws IOException {
		init();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		players = new int[N][10];
		for(int i=0 ;i <N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1 ;j<=9 ;j ++)
				players[i][j] = Integer.parseInt(st.nextToken());
			
			// 1번 선수를 4번 타자로 swap
			int p = players[i][1];
			for(int j=2 ; j<=4 ; j++) players[i][j-1] = players[i][j];
			players[i][4] = p;
		}
	}
}
