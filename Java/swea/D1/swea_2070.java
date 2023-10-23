package swea.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2070 {
    // 큰 놈, 작은 놈, 같은 놈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a < b) sb.append("#" + (i+1) + " <\n");
            else if(a == b) sb.append("#" + (i+1) + " =\n");
            else sb.append("#" + (i+1) + " >\n");
        }

        System.out.println(sb);
    }
}
