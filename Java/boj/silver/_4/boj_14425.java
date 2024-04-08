package boj.silver._4;

import java.io.*;
import java.util.*;

public class boj_14425 {
    // 문자열 집합
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static HashSet<String> S;
    static int cnt;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < m; i++)
            check(br.readLine());
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        S = new HashSet<>();
        cnt = 0;
        for (int i = 0; i < n; i++)
            S.add(br.readLine());
    }

    private static void check(String str) {
        if(S.contains(str)) cnt++;
    }
}
