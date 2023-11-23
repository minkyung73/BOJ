package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1074 {
    // Z
    private static int N, r, c;
    private static int[][] arr;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[(int) Math.pow(2, N-1)][(int) Math.pow(2, N-1)];

        Z(r, c);
        System.out.println(cnt);
    }

    public static void Z(int x, int y) {
        cnt++;
        if(x == r && y == c)
            return ;

        if(y % 2 == 0) {
            Z(x, y+1);
        }

    }
}
