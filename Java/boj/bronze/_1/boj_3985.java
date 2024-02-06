package boj.bronze._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3985 {
	// 롤 케이크
	static int L;
	static int n;
	static int[][] pk;
	static int[] cake;
	static boolean[] visited;
	static int expected_num, real_num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// initialize
		L = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		pk = new int[n+1][2];
		cake = new int[n+1];
		visited = new boolean[L+1];
		
		// input pi and ki
		for(int i=1 ; i<=n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pk[i][0] = Integer.parseInt(st.nextToken());
			pk[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// get cakes
		for(int i=1 ; i<=n ; i++) {
			cake[i] = getCake(i);
		}
		
		// output
		System.out.println(sb);
	}

	public static int getCake(int idx) {
		int cnt = 0;
		
		for(int i=pk[idx][0] ; i<=pk[idx][1] ; i++) {
			if(!visited[i]) cnt++;
		}
		
		return cnt;
	}
}
