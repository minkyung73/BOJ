package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660 {
	// 구간 합 구하기 5
	
	static int n, m;
	static int[][] map;
	static Node start, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		// map input
		for(int i=1 ; i<=n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<=n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j-1];
			}
		}
		
		// start and end input
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
			// calculate
			sb.append(calc()).append("\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	public static int calc() {
		int res = 0;
		
		for(int i = start.x ; i<= end.x ; i++)
			res += map[i][end.y] - map[i][start.y-1];
		
		return res;
	}
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
