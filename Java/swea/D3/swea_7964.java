package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7964 {
    // 부먹왕국의 차원 관문
    static int n, d, cnt;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // initialize
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            map = new int[n];
            cnt = 0;

            // map input
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            // calculate
            int temp = 0;
            for (int m : map) {
                if(m == 1) {
                    temp = 0;
                    continue;
                }

                temp++;

                if(temp == d) {
                    cnt++;
                    temp = 0;
                }
            }

            // result
            sb.append("#" + (i+1) + " " + cnt + "\n");
        }

        // output
        System.out.println(sb);
    }
}
