package boj.silver._1;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11403 {
	// 경로 찾기
	static int n;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		init();
		floyd_warshall();
		print();
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dist = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ;j ++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void floyd_warshall() {
		for(int k=0 ; k<n ; k++) {
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ;j<n ; j++) {
					// (i,k)가 연결되어 있고, (k, j)가 연결되어 있다면 (i, j)는 연결할 수 있다.
					// i에서 j까지 가는데에 k를 거치는 것
					if(dist[i][k] == 1 && dist[k][j] == 1)
						dist[i][j] = 1;
				}
			}
		}
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ;j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
