package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1654 {
    // 랜선 자르기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(binarySearch(arr, k));
    }

    public static int binarySearch(int[] arr, int k) {
        long l = 1, r = arr[arr.length-1];
        long ans = 0;

        while (l <= r) {
            long mid = (l+r) / 2;
//            System.out.println(mid);
            long cnt = 0;

            for(int i=0 ; i<arr.length ; i++)
                cnt += (long) arr[i] / mid;

//            if(cnt == k) return mid;
            if(cnt < k) r = mid-1;
            else {
                ans = mid;
                l = mid+1;
            }
        }

        return (int) ans;
    }
}
