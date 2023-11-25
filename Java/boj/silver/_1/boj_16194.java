package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16194 {
    // 카드 구매하기 2
    private static int n;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=i ; j>=1 ; j--) {
                dp[i] = Math.min(dp[i], arr[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
