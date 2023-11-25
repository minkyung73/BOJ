package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805 {
    // 나무 자르기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int result = binarySearch(arr, m);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int key) {
        int l = 0, r = arr[arr.length-1];
        int ans = 0;

        while (l < r) {
            int mid = (l+r) / 2;
            long temp_sum = 0;

            for(int i=0 ; i<arr.length ; i++)
                if(arr[i] > mid) temp_sum += (long) arr[i] - mid;

            if(temp_sum == key) return mid;
            else if(temp_sum > key) {
                ans = mid;
                l = mid+1;
            }
            else r = mid;
        }

        return ans;
    }
}
