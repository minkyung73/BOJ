package swea.D4;

import java.io.*;
import java.util.StringTokenizer;

public class swea_9282 {
	// 초콜릿과 건포도
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int m, n;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=t ; i++) {
			init();
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m ;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
	}

}
