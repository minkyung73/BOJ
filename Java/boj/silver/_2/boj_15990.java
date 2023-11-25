package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15990 {
    // 1, 2, 3 더하기 5

    private static long[][] dp = new long[100001][4];
    private static long mod = 1000000009;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for(int i=0 ; i<t ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4 ; i<=max ; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%mod;
            dp[i][3] = (dp[i-3][2] + dp[i-3][1])%mod;
        }

        for(int i=0 ; i<t ; i++) {
            int idx = arr[i];
            long result = dp[idx][1] + dp[idx][2] + dp[idx][3];
            sb.append(result%mod + "\n");
        }
        System.out.println(sb);

    }
}
