package boj.silver._3;

import java.io.*;
import java.util.*;

public class boj_11726_2 {
	// 2xn 타일링
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int res = DP();
		System.out.println(res);
	}

	private static int DP() {
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3 ; i<=n ; i++)
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		
		return dp[n];
	}

}
