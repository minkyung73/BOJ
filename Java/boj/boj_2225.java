package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2225 {
    // 합 분해
    private static int n, k;
    private static int dp[][];
    private static int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][n+1];

        for(int i=0 ; i<=n ; i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for(int i=0 ; i<=k ; i++) {
            dp[1][i] = i;
        }

        for(int i=2 ; i<=n ; i++) {
            for(int j=2 ; j<=k ; j++)
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
        }

        System.out.println(dp[n][k]);
    }
}
