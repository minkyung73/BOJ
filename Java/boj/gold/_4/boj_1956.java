package boj.gold._4;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1956 {
	// 운동
	
	static int v, e;
	static int[][] dist;
	static final int INF = 40_000_000;
	
	public static void main(String[] args) throws IOException{
		init();
		floyd_warshall();
		int res = cycle();
		System.out.println(res);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
		dist = new int[v+1][v+1];
		
		for(int i=1 ;i <=v ; i++) {
			for(int j=1 ; j<=v ; j++) {
				dist[i][j] = i==j ? 0 : INF;
			}
		}
		
		for(int i=0 ;i <e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			dist[a][b] = Math.min(dist[a][b], c);
		}
	}
	
	private static void floyd_warshall() {

		for(int k=1 ; k<=v ; k++) {
			for(int i=1 ; i<= v ; i++) {
				for(int j=1 ; j<=v ; j++) {
					if(i==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	public static int cycle() {
		int answer = INF;
		
		for(int i=1 ; i<=v ; i++) {
			for(int j=1 ; j<=v ; j++) {
				if(i==j) continue;
				if(dist[i][j] != INF && dist[j][i] != INF)
					answer = Math.min(dist[i][j] + dist[j][i], answer);
			}
		}
		
		return answer == INF ? -1 : answer;
	}
	
	public static void print() {
		for(int i=1 ;i <=v ; i++) {
			for(int j=1 ; j<=v ; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

}
