package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559 {
    //  수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int res = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //
        for(int i=0 ; i<=n-k ; i++) {
            int sum = 0;
            for(int j=i ;j<i+k ;j++) {
                sum += arr[j];
            }
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
