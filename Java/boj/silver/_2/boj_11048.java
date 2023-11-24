package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_11048 {
    // 이동하기
    private static int n, m;
    private static int[][] arr, dp;
    private static int[] dx = {1, 0, 1};
    private static int[] dy = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1 ; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // output
        System.out.println(dp[n][m]);
    }
}
