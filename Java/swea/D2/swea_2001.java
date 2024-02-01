package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
    // 파리 퇴치
    private static int n, m;
    private static int[][] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // input
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for(int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<n ; k++) arr[j][k] = Integer.parseInt(st.nextToken());
            }
            
            // function call
            sb.append("#" + (i+1) + " " +  fly() + "\n");
        }
        
        // output
        System.out.println(sb);
    }

    public static int fly() {
        int result = 0, idx = 0;
        dp = new int[n * (n-m+1)];

        // 
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n-m+1 ; j++) {
                for(int k = j ; k < j+m ; k++) {
                    dp[idx] += arr[i][k];
                }
                idx++;
            }
        }

        // 
        for(int i=0 ; i<(n-m+1)*(n-m+1) ; i++) {
            int temp = 0;
            idx = i;
            for(int j=0 ; j<m ; j++) {
                temp += dp[idx];
                idx += n-m+1;
            }

            if(temp > result) result = temp;
        }

        return result;
    }
}
