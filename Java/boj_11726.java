import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726 {
    // 2 x n 타일링
    private static int n;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];

        for(int i=1 ; i<=n ; i++) {
            if(i == 1 || i == 2) dp[i] = i;
            else dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
