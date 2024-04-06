package boj.silver._3;

import java.util.*;
import java.io.*;

public class boj_1463_2 {
	// 1로 만들기
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[100001];

		int res = DP();
		System.out.println(res);
	}
	
	public static int DP() {
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4 ; i<=n ; i++) {
			int min = dp[i-1];
			
			if(i%2 == 0) min = Math.min(min, dp[i/2]);
			if(i%3 == 0) min = Math.min(min, dp[i/3]);
			
			dp[i] = min + 1;
		}
		
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
