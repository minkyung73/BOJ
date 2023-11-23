package codeup.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class code_3702 {
    // 파스칼의 삼각형 2
    private static int r, c;
    private static long[][] dp = new long[51][51];
    private static long mod = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i=1 ; i<=r ; i++) {
            for(int j=1 ; j<=c ; j++) {
                if(i==1 || j==1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        System.out.println(dp[r][c]);
    }
}
