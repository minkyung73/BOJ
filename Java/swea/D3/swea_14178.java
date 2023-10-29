package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.StreamSupport;

public class swea_14178 {
    // 1차원 정원
    private static int n, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ;i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            int result = flower(n, d);
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static int flower(int n, int d) {
        return (int) Math.ceil((double) n / (d * 2 + 1));
    }
}
