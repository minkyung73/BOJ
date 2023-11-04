package boj;

import java.io.IOException;
import java.util.Scanner;

public class boj_10844 {
    // 쉬운 계단 수
    private static int n;
    private static long[][] dp;
    private static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n+1][10];

        for(int i=1 ; i<=n ; i++)
            stairs(i);

        long sum = 0;
        for(int i=0 ; i<=9 ; i++) {
//            System.out.print(dp[n][i] + " ");
            sum = (sum + dp[n][i]) % mod;
        }

        System.out.println(sum);
    }

    public static void stairs(int num) {
        if(num == 1) {
            for(int i=1 ; i<=9 ; i++)
                dp[num][i] = 1;
            return ;
        }

        for(int i=0 ; i<=9 ; i++) {
            if(i == 0)
                dp[num][0] = dp[num-1][1] % mod;
            else if(i == 9)
                dp[num][9] = dp[num-1][8] % mod;
            else
                dp[num][i] = (dp[num-1][i-1] + dp[num-1][i+1]) % mod;
        }
    }
}
