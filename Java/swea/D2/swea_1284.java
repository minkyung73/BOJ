package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1284 {
    // 수도 요금 경쟁
    private static int p, q, r, s, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            int result = Math.min(computeA(), computeB());
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static int computeA() {
        return p * w;
    }

    public static int computeB() {
        if(w < r) return q;
        else return q + (w-r) * s;
    }
}
