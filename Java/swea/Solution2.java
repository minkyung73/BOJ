package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    // 문제 2
    private static int n, p, result, sum;
    private static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            arr1 = new int[n];
            arr2 = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++)
                arr1[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++)
                arr2[j] = Integer.parseInt(st.nextToken());

            // compute height of plant
            result = 0;
            plant(arr1[0], 1, 1, 0);    // function call
            plant(arr2[0], 1, 2, 0);    // function call

            // output
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static void plant(int height, int depth, int num, int sum) {
        sum += height;

        if(depth == n) {
            result = Math.max(result, sum);
            return ;
        }

        int d = depth+1;
        int h1, h2;
        if(num == 1) {
            h1 = arr1[depth] - 2 <= 0 ? 1 : arr1[depth] - p;
            h2 = arr2[depth];
        }
        else {
            h1 = arr1[depth];
            h2 = arr2[depth] - 2 <= 0 ? 1 : arr2[depth] - p;
        }


        plant(h1, d, 1, sum);
        plant(h2, d, 2, sum);

    }
}
