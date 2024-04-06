package boj.silver._3;

import java.util.*;
import java.io.*;

public class boj_9095 {
	// 1, 2, 3 더하기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0 ; i<t ; i++) {
			int n = Integer.parseInt(br.readLine());
			int res = DP(n);
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int DP(int n) {
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4 ; i<=n ; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		return dp[n];
	}
}
