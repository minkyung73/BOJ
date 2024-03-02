package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070_DP {
    // 파이프 옮기기
    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(DP());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1][3];

        // map
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        // 가로
        for (int i = 3; i <= N ; i++) {
            if(map[1][i] == 1) break;
            dp[1][i][0] = 1;
        }

        // 대각선
        if(map[2][3] != 1 && map[1][3] != 1 && map[2][2] != 1) dp[2][3][1] = 1;

        // 세로
        if(dp[2][3][1] == 1) {
            for (int i = 3; i <= N ; i++) {
                if(map[i][1] == 1) break;
                dp[i][3][2] = 1;    // 세로
            }
        }
    }

    public static int DP() {
        for (int i = 2; i <= N ; i++) {
            for (int j = 4; j <= N ; j++) {
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];

                if(map[i][j-1] != 1 && map[i-1][j] != 1 && map[i-1][j-1] != 1)
                    dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        return dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
    }

    public static void print() {
        for(int i=1 ; i<=N ; i++) {
            for(int j=1 ;j <=N ; j++)
                System.out.print("["+dp[i][j][0] + "," + dp[i][j][1]+"," + dp[i][j][2]+"]  ");
            System.out.println();
        }
    }
}
