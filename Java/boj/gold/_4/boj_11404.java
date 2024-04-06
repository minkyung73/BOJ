package boj.gold._4;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11404 {
	// 플로이드 
	
	static int n, m;
	static int[][] dist;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		init();
		floyd_warshall();
		print();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dist = new int[n+1][n+1];
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ; j++) {
				if(i==j) continue;
				dist[i][j] = INF;
			}
		}
	
		for(int i=0 ; i<m ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			dist[a][b] = Math.min(dist[a][b], c);
		}
	}
	
	private static void floyd_warshall() {
		for(int k=1 ; k<=n ; k++) {
			for(int i=1 ;i<=n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					if(i==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ;j ++) {
				if(dist[i][j] == INF) sb.append("0 ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
