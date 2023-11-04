package boj;

import java.io.IOException;
import java.util.Scanner;

public class boj_2193 {
    // 이친수
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for(int i=4 ; i<=n ; i++) {
            for(int j=i-2 ; j>=1 ; j--) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }

        System.out.println(dp[n]);
    }
}
