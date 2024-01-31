package boj.silver._4;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2839 {
	static int N;
	static int ans = Integer.MAX_VALUE;
	
    public static void main(String[] args) {
        // 설탕배달

        // input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        // 예외 테케가 있어서 실패
//        greedy(N);
        
        // 시간초과
//        recursive(N, 0);
//        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        
        //
        dp();
    }
    
    private static void dp() {
		/**
		 * 1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
		 * x  x  1  x  1  2  x  2  3  2   3   4   3   4   3
		 * -> 규칙
		 * 		dp[i] = dp[i-3] + 1 이거나 
		 * 		dp[i] = dp[i-5] + 1
		 * 
		 * -> 즉, 
		 * 		Math.min(dp[i-3], dp[i-5]) + 1
		 */
    	
    	// initialize
    	int[] dp = new int[N+1];
    	Arrays.fill(dp, 2000);
    	dp[3] = 1;
    	if(N >= 5) dp[5] = 1;
    	
    	for(int i=6;  i<dp.length ; i++) {
    		dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
    	}
    	System.out.println(dp[N] >= 2000 ? -1 : dp[N]);
	}

	private static void recursive(int n, int cnt) {
		// basis part
    	if(n < 0) {
    		return ;
    	}
    	if(n == 0) {
    		ans = Math.min(ans,  cnt);
    		return ;
    	}
    	
    	// inductive part
    	recursive(n-5, cnt+1);
    	recursive(n-3, cnt+1);
	}

	private static void greedy(int n) {
    	int cnt = 0;
    	while(n % 5 != 0) {
    		n -= 3;
    		cnt++;
    	}
    	
    	if(n < 0) System.out.println(-1);
    	else {
    		cnt += n/5;
    		System.out.println(cnt);
    	}
    }
}
