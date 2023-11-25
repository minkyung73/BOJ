package boj.silver._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047 {
    // 동전 0
    private static int n, k, cnt = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // greedy
        for(int i= n-1 ; i>=0 ; i--) {
            if(arr[i] <= k) {
                cnt += k/arr[i];
                k %= arr[i];
            }
        }

        // output
        System.out.println(cnt);
    }
}
