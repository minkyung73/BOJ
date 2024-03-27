package boj.silver._3;

import java.io.*;
import java.util.*;

public class boj_2579_2 {
	// 계단 오르기
	static int n;
	static int[] stairs;
	
	public static void main(String[] args) throws IOException {
		init();
		int res = DP();
		System.out.println(res);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		stairs = new int[301];
		
		for(int i=1 ; i<=n ; i++)
			stairs[i] = Integer.parseInt(br.readLine());
	}

	public static int DP() {
		int[][] dp = new int[301][2];
		
		dp[1][0] = 0;
		dp[1][1] = stairs[1];
		
		for(int i=2 ; i<=n ; i++) {
			dp[i][0] = stairs[i] + dp[i-1][1];
			dp[i][1] = stairs[i] + Math.max(dp[i-2][0], dp[i-2][1]);
		}
		
//		for(int i=1 ; i<=n ; i++)
//			System.out.println(Arrays.toString(dp[i]));
		
		return Math.max(dp[n][0], dp[n][1]);
	}
}
