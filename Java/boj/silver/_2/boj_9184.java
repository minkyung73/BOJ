package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9184 {
    // 신나는 함수 실행
    private static int a, b, c;
    private static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            // function call
            int result = w(a, b, c);
//            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) return 1;

        if(rangeCheck(a, b, c) && dp[a][b][c] !=  0) return dp[a][b][c];

        if(a>20 || b>20 || c>20) return dp[20][20][20] = w(20, 20, 20);

        if(a<b && b<c)
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static boolean rangeCheck(int a, int b, int c) {
        return a >= 0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20;
    }
}
