package swea.etc;

import java.io.*;
import java.util.*;

public class swea_4014 {
	// [모의 SW 역량테스트] 활주로 건설
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, X;
	static int[][] map;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			for(int j=0 ; j<N ; j++) {
				makeWidth(j);
				makeHeight(j);
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		map = new int[N][N];
		cnt = 0;
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void makeWidth(int row) {
		boolean[] installed = new boolean[N];
		int pre = map[row][0];
		
		for(int i=1 ; i<N ; i++) {
			// 높이가 같은 경우
			if(pre == map[row][i]) pre = map[row][i];
			
			// 높이가 더 높아서 올라가는 활주로를 설치하는 경우
			else if(pre < map[row][i]) {
				// 경사가 1 차이 나는지 확인
				if(pre+1 != map[row][i]) return ;
				
				// 범위 확인
				if(i-X < 0) return ;
				
				// 앞에 x개 확인
				for(int j=i-X ; j<i ; j++) {
					if(map[row][j] != map[row][i]-1) return ;
					if(installed[j]) return ;
				}
				
				// 활주로 설치
				for(int j=i-X ; j<i ; j++) installed[j] = true;
				
				pre = map[row][i];
			}
			
			// 높이가 더 낮아서 내려가는 활주로를 설치하는 경우
			else if(pre > map[row][i]) {
				// 경사가 1 차이 나는지 확인
				if(pre - 1 != map[row][i]) return ;
				
				// 범위 확인
				if(i+X > N) return ;
				
				// 뒤에 x개 확인
				for(int j=i+1 ; j<i+X ; j++) {
					if(map[row][j] != map[row][i]) return ;
					if(installed[j]) return ;
				}
				
				// 활주로 설치
				for(int j=i+1 ; j<i+X ; j++) installed[j] = true;
				
				pre = map[row][i];
				i += X-1;
			}
		}
		
//		System.out.println("row: " + row);
		cnt++;
	}
	
	public static void makeHeight(int col) {
		boolean[] installed = new boolean[N];
		int pre = map[0][col];
		
		for(int i=1 ; i<N ; i++) {
			// 높이가 같은 경우
			if(pre == map[i][col]) pre = map[i][col];
			
			// 높이가 더 높아서 올라가는 활주로를 설치하는 경우
			else if(pre < map[i][col]) {
				// 경사가 1 차이 나는지 확인
				if(pre+1 != map[i][col]) return ;
				
				// 범위 확인
				if(i-X < 0) return ;
				
				// 앞에 x개 확인
				for(int j=i-X ; j<i ; j++) {
					if(map[j][col] != map[i][col]-1) return ;
					if(installed[j]) return ;
				}
				
				// 활주로 설치
				for(int j=i-X ; j<i ; j++) installed[j] = true;
				
				pre = map[i][col];
			}
			
			// 높이가 더 낮아서 내려가는 활주로를 설치하는 경우
			else if(pre > map[i][col]) {
				// 경사가 1 차이 나는지 확인
				if(pre - 1 != map[i][col]) return ;
				
				// 범위 확인
				if(i+X > N) return ;
				
				// 뒤에 x개 확인
				for(int j=i+1 ; j<i+X ; j++) {
					if(map[j][col] != map[i][col]) return ;
					if(installed[j]) return ;
				}
				
				// 활주로 설치
				for(int j=i+1 ; j<i+X ; j++) installed[j] = true;
				
				pre = map[i][col];
				i += X-1;
			}			
		}
		
//		System.out.println("col: " + col);
		cnt++;
	}
	
	public static boolean checkAlreadyExistAirStrip() {
		return true;
	}
}
