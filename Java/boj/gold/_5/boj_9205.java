package boj.gold._5;

import java.awt.Point;
import java.io.*;
import java.util.StringTokenizer;

public class boj_9205 {
	// 맥주 마시면서 걸어가기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static Point[] nodes; 
	static int[][] dist;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<t ; i++) {
			init();
			floyd_warshall();
			if(dist[0][n-1] > 0 && dist[0][n-1] < INF) sb.append("happy\n");
			else sb.append("sad\n");
		}
		
		System.out.println(sb);
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine())+2;
		
		nodes = new Point[n];
		dist = new int[n][n]; 
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Point(x, y);
		}
		
		// 
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ;j<n ;j++) {
				if(i==j) continue;
				dist[i][j] = INF;
				
				int d = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
				if(d <= 1000) dist[i][j] = 1;
			}
		}
	}
	
	public static void floyd_warshall() {
		for(int k=0 ; k<n ; k++) {
			for(int i=0 ; i<n ;i ++) {
				for(int j=0 ; j<n ;j++) {
					if(i==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
