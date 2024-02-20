package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6987 {
	// 월드컵
	static int[][] leagues;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		
		for(int i=0 ; i<4 ; i++) {
			init();
			worldCup(0, 0);
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0 ; i<6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<3 ; j++) {
				leagues[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	/**
	 * @param nation: 국가 (0~5)
	 * @param wdl: win, draw, lose (0~2)
	 */
	public static void worldCup(int nation, int wdl) {
		// basis part
		if(nation == 6) {
			sb.append(isPossible() ? 1 : 0).append(" ");
			return ;
		}
		
		// inductive part
		
		
		
	}
	
	public static boolean isPossible() {
		for(int i=0 ; i<6 ; i++) {
			for(int j=0 ; j<3 ; j++) {
				if(leagues[i][j] != 0) return false;
			}
		}
		return true;
	}
}
