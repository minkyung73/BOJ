package boj.silver._3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501 {
	// 퇴사
	static int n;
	static int[] t;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		init();
		int res = DP();
		System.out.println(res);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		t = new int[n];
		p = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static int DP() {
		int[] dp = new int[n+1];
		
		for(int i= 0 ; i<n ; i++) {
			if(i + t[i] <= n) 
				dp[i+t[i]] = Math.max(p[i] + dp[i], dp[i+t[i]]);
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		
		return dp[n];
	}
}
