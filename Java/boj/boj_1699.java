package boj;

import java.io.IOException;
import java.util.Scanner;

public class boj_1699 {
    // 제곱수의 합
    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[100001];

        for(int i=1 ; i<=n ; i++) {
            dp[i] = i;
            for(int j=1 ; j<=i/2 ; j++) {
                if(j*j == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
