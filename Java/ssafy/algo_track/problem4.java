package ssafy.algo_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class problem4 {
    // 두 개의 숫자열 (D2)
    static int[] small_arr, big_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // n & m input
            if(n < m) {
                small_arr = new int[n];
                big_arr = new int[m];
            }
            else {
                small_arr = new int[m];
                big_arr = new int[n];
            }

            int max = 0;    // initialize

            // n & m arr input
            if(n < m) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    small_arr[j] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    big_arr[j] = Integer.parseInt(st.nextToken());
                }
            } else {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    big_arr[j] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    small_arr[j] = Integer.parseInt(st.nextToken());
                }
            }

            // function call - calculate
            for (int j = 0; j <= Math.abs(n - m); j++) {
                max = Math.max(max, calculate(j));
            }

            // result
            sb.append("#" + (i + 1) + " " + max + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static int calculate(int n) {
        int res = 0;

        for (int i = 0; i < small_arr.length; i++) {
            res += small_arr[i] * big_arr[i+n];
        }

        return res;
    }
}
