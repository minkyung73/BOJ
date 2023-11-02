package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3431 {
    // 준환이의 운동관리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            sb.append("#" + (i+1) + " " + exercise(L, U, X) + "\n");
        }
        System.out.println(sb);
    }

    public static int exercise(int l, int u, int x) {
        if(x > u) return -1;
        else if(x < l) return l - x;
        else return 0;
    }
}
