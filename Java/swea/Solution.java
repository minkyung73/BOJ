package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    // 문제 1
    private static int n, k;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int j=0 ;j<n ; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            // compute number of player
            answer = 1;
            player();   // function call

            sb.append("#" + (i+1) + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    public static void player() {
        int cnt;

        for(int i=0 ; i<n ; i++) {
            cnt = 1;
            for(int j=i+1 ; j<n ; j++) {
                if(arr[j] - arr[i] <= k) {
                    cnt++;
                }
                else break;
            }
            answer = Math.max(cnt, answer);
        }
    }
}
