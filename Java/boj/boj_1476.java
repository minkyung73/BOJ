package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476 {
    // 날짜 계산
    private static int E, S, M;
    private static int e=0, s=0, m=0;
    private static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (E != e || S != s || M != m) {
            year += 1;

            e += 1;
            s += 1;
            m += 1;

            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
        }

        System.out.println(year);
    }
}
