package swea.D6;

import java.io.*;
import java.util.*;

public class swea_1263 {
	// [S/W 문제해결 응용] 8일차 - 사람 네트워크2
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int[][] dist;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=t ; i++) {
			init();
			floyd_warshall();
			int res = cc();
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		dist = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ;j<n ;j ++) {
				int num = Integer.parseInt(st.nextToken());
				if(i==j) continue;
				if(num == 1) dist[i][j] = 1;
				else dist[i][j] = INF;
			}
		}
	}
	
	public static void floyd_warshall() {
		for(int k=0 ; k<n ; k++) {
			for(int i = 0 ; i<n ;i ++) {
				for(int j=0 ;j<n ;j ++) {
					if(i==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	public static int cc() {
		int minDist = Integer.MAX_VALUE;
		int idx = -1;
		
		for(int i=0 ; i<n ; i++) {
			int tempDist = 0;
			for(int j=0 ;j<n ;j++) {
				if(dist[i][j] == INF) continue;
				tempDist += dist[i][j];
			}
			
			if(tempDist < minDist) {
				minDist = tempDist;
				idx = i;
			}
		}
		
		return minDist;
	}
}
