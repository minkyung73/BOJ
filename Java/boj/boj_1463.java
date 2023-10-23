package boj;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463 {
    static Integer[] dp;

    static int recur(int N) {
        if(dp[N] == null) {
            if(N % 6 == 0) {
                dp[N] = Math.min(recur(N-1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N/3), recur(N-1)) + 1;
            }
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N/2), recur(N-1)) + 1;
            }
            else {
                dp[N] = recur(N-1) + 1;
            }
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        // 1로 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;
        System.out.println(recur(n));
    }
}
