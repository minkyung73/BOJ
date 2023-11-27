package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    // Z
    private static int n, r, c;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Z((int) Math.pow(2, n), 0, 0);
        System.out.println(cnt);
    }

    public static void Z(int size, int x, int y) {
        if(x == r && y == c) return ;

        if(r < x + size/2 && c >= y + size/2) { // 제 1 사분면
            cnt += Math.pow((long) (size/2), 2);
            Z(size/2, x, y + size/2);
        }
        else if(r < x + size/2 && c < y + size/2) { // 제 2 사분면
            Z(size/2, x, y);
        }
        else if(r >= x + size/2 && c < y + size/2) { // 제 3 사분면
            cnt += Math.pow((long) (size/2), 2) * 2;
            Z(size/2, x + size/2, y);
        }
        else { // 제 4 사분면
            cnt += Math.pow((long) (size/2), 2) * 3;
            Z(size/2, x + size/2, y + size/2);
        }
    }
}
