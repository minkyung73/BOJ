package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2521 {
    // 예산
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long sum = 0L;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += (long) arr[i];
        }
        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if(sum <= m) System.out.println(arr[arr.length-1]);
        else if(m < arr[0]) System.out.println(m/n);
        else {
            int ans = binarySearch(arr);
            System.out.println(ans);
        }
    }

    public static int binarySearch(int[] arr) {
        int l = 0, r = arr[arr.length-1];
        int ans = 0;

        while (l < r) {
            int mid = (l+r) / 2;
            int temp_sum = 0;

            for (int i : arr)
                temp_sum += Math.min(i, mid);

            if(temp_sum == m) {
                ans = mid;
                return ans;
            }
            else if(temp_sum < m) {
                l = mid+1;
                if(mid > ans) ans = mid;
            }
            else r = mid;
        }

        return ans;
    }
}
