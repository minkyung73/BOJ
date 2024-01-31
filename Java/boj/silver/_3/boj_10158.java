package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10158 {
    // 개미
    static int w, h;
    static int p, q;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // input
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());

        // calculate
        p = (p+t) % (2*w);
        q = (q+t) % (2*h);

        if(p > w) p = 2*w - p;
        if(q > h) q = 2*h - q;

        // output
        sb.append(p).append(" ").append(q);
        System.out.println(sb);
    }
}
