package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1149 {
    // RGB 거리
    private static int n, sum = 0;
    private static int[][] rgb, dp;
    private static int[][] dir = {{1, 2}, {0, 2}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rgb = new int[n][n];
        dp = new int[n][n];

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<3 ; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for(int i=1 ; i<n ; i++) {
            for(int j=0 ; j<3 ; j++) {
                int[] temp = dir[j];
                dp[i][j] = rgb[i][j] + Math.min(dp[i-1][temp[0]], dp[i-1][temp[1]]);
            }
        }

//        for(int i=0 ; i<n ; i++) {
//            for(int j=0 ; j<3 ; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int result = Integer.MAX_VALUE;
        for(int i=0 ; i<3 ; i++)
            result = Math.min(result, dp[n-1][i]);

        System.out.println(result);
    }
}
