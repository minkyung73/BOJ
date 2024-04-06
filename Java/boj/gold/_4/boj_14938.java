package boj.gold._4;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14938 {
	// 서강그라운드
	static int n, m, r;
	static int[] items;
	static int[][] dist;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		init();
		floyd_warshall();
//		print();
		int res = getItems();
		System.out.println(res);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 지역 수
		m = Integer.parseInt(st.nextToken());	// 수색범위
		r = Integer.parseInt(st.nextToken());	// 길의 개수
	
		items = new int[n+1];
		dist = new int[n+1][n+1];
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ;j ++) {
				if(i==j) continue;
				dist[i][j] = INF;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=n ; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1 ; i<=r ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			dist[a][b] = c;
			dist[b][a] = c;
		}
	}
	
	public static void floyd_warshall() {
		for(int k=1 ; k<=n ; k++) {
			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=n ; j++ ) {
					if(i==j) continue;
//					if(dist[i][k] + dist[k][j] <= m)
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	public static int getItems() {
		int maxItems = 0;
		
		for(int i=1 ; i<=n ; i++) {
			int tempItems = 0;
			for(int j=1 ;j <=n ;j ++) {
//				if(dist[i][j] == INF) continue;
				if(dist[i][j] <= m)
					tempItems += items[j];
			}
			maxItems = Math.max(maxItems, tempItems);
		}
		
		return maxItems;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ;j ++) {
				if(dist[i][j] == INF) sb.append("INF ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
