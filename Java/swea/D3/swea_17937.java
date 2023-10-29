package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_17937 {
    // 큰 수의 최대공약수
    private static String a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = st.nextToken();
            b = st.nextToken();

            if(a.equals(b)) sb.append("#" + (i+1) + " " + a + "\n");
            else sb.append("#" + (i+1) + " 1\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int p, int q) {
        if(q == 0) return p;
        return gcd(q, p%q);
    }
}
