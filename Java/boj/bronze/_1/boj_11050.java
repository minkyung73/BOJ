package boj.bronze._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11050 {
    // 이항 계수 1
    private static int n, k;
    private static int[][] dp;

    public static int BC(int n, int k) {
        if(dp[n][k] > 0) return dp[n][k];

        if(n == k || k == 0) return 1;

        return dp[n][k] = BC(n-1, k-1) + BC(n-1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];

        System.out.println(BC(n, k));
    }
}
