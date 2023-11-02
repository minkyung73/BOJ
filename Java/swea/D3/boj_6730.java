package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_6730 {
    // 장애물 경주 난이도
    private static int n;
    private static int[] arr;
    private static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ;i<T ; i++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            min = 0;
            max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ;j<n ;j++)
                arr[j] = Integer.parseInt(st.nextToken());

            obstacle();
            sb.append("#" + (i+1) + " " + max + " " + min + "\n");
        }
        System.out.println(sb);
    }

    public static void obstacle() {
        int cur = arr[0];

        for(int i=1 ; i<n ; i++) {
            int next = arr[i];

            if(cur < next) max = Math.max(max, next-cur);
            if(next < cur) min = Math.max(min, cur-next);

            cur = arr[i];
        }
    }
}
