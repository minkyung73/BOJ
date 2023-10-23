package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11727 {
    // 2 x n 타일링 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+2];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3 ; i<=n ; i++){
            if(i % 2 == 1)
                dp[i] = (dp[i-1] * 2 -1) % 10007;
            else
                dp[i] = (dp[i-1] * 2 +1) % 10007;
        }

        System.out.println(dp[n]);
    }
}
