package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1932 {
    // 정수 삼각형
    private static int n;
    private static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        dp[1][1] = arr[1][1];
        for(int i=2 ; i<=n ; i++) {
            for(int j=1 ; j<=i ; j++) {
                if(j==1) dp[i][j] = arr[i][j] + dp[i-1][j];
                else if(j==i) dp[i][j] = arr[i][j] + dp[i-1][j-1];
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        // max
        int max = 0;
        for(int i=1 ; i<=n ; i++)
            max = Math.max(max, dp[n][i]);

        // result
        System.out.println(max);
    }
}
