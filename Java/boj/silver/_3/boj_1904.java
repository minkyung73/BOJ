package boj.silver._3;

import java.io.IOException;
import java.util.Scanner;

public class boj_1904 {
    // 01타일

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3 ; i<=n ; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;

        System.out.println(dp[n]);
    }
}
