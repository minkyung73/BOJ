package ssafy.algo_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem5 {
    // [S/W 문제해결 기본] 1일차 - 최빈수 구하기 (D2)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            int max = 0, max_idx = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;

                if(arr[num] > max) {
                    max = arr[num];
                    max_idx = num;
                }
                else if(arr[num] == max) {
                    max_idx = Math.max(num, max_idx);
                    max = arr[max_idx];
                }
            }

            sb.append("#" + t + " " + max_idx + "\n");
        }

        // output
        System.out.println(sb);
    }
}
