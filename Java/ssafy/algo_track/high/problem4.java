package ssafy.algo_track.high;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4 {
    // [S/W 문제해결 응용] 3일차 - 공통조상
    static int v, e, n1, n2;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            map = new int[v+1][v+1];

            for (int j = 0; j < e; j++) {
                int u1 = Integer.parseInt(st.nextToken());
                int u2 = Integer.parseInt(st.nextToken());
                map[u1][u2] = 1;
            }

            //

        }

        // output
        System.out.println(sb);
    }

    public static class Node {

    }
}
