package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1206 {
    // [S/W 문제해결 기본] 1일차 - View
    private static int cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<10 ; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n];
            cnt = 0;

            for(int j=0 ;j<n ; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            // function call
            view(n);

            // output
            sb.append("#" + (i+1) + " " + cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void view(int n) {
        for(int i=2 ; i<n-2 ; i++) {
            if(left(i) != 0 && right(i) != 0)
                cnt += Math.min(left(i), right(i));
        }
    }

    public static int left(int idx) {
        int max = Math.max(arr[idx-1], arr[idx-2]);

        if(arr[idx] > max) return arr[idx]-max;
        else return 0;
    }

    public static int right(int idx) {
        int max = Math.max(arr[idx+1], arr[idx+2]);

        if(arr[idx] > max) return arr[idx]-max;
        else return 0;
    }
}
