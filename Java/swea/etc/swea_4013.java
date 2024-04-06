package swea.etc;

import java.io.*;
import java.util.*;

public class swea_4013 {
	// [모의 SW 역량테스트] 특이한 자석
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int K;
	static int[][] magnet;
	static int[] rotateInfo;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<= T ; i++) {
			init();
			
			for(int j=0 ; j<K ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				rotateInfo = new int[4];
				specialMagnet(num, dir);
				rotate();
			}
			sb.append("#").append(i).append(" ").append(calc()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		K = Integer.parseInt(br.readLine());
		magnet = new int[4][8];
		
		for(int i=0 ; i<4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<8 ;j++) {
				magnet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void specialMagnet(int num, int dir) {
		rotateInfo[num] = dir;
		
		//
		int left = num-1;
		int right = num+1;
		if(left >= 0 
				&& rotateInfo[left] == 0 
				&& magnet[left][2] != magnet[num][6]) {
			specialMagnet(left, -1 * dir);
		}
		
		if(right < 4 
				&& rotateInfo[right] == 0
				&& magnet[right][6] != magnet[num][2]) {
			specialMagnet(right, -1 * dir);
		}
	}
	
	public static void rotate() {
		for(int i=0 ; i<4 ; i++) {
			// 회전하지 않는 경우
			if(rotateInfo[i] == 0) continue;
			// 시계 방향
			else if(rotateInfo[i] == 1) {
				int temp = magnet[i][7];
				for(int j=7 ; j>=1 ; j--)
					magnet[i][j] = magnet[i][j-1];
				magnet[i][0] = temp;
			}
			// 반시계 방향
			else {
				int temp = magnet[i][0];
				for(int j=0 ; j<=6 ; j++) 
					magnet[i][j] = magnet[i][j+1];
				magnet[i][7] = temp;
			}
		}
	}
	
	public static int calc() {
		int score = 0;
		for(int i=0 ; i<4 ; i++) {
			if(magnet[i][0] == 1) score += (int) Math.pow(2, i);
		}
		return score;
	}
}
