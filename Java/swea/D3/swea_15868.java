package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_15868 {
    // XOR 2차원 배열
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            boolean flag = true;
            for(int j=0 ; j<n ; j++) {
                String str = br.readLine();
                int cnt0 = 0, cnt1 = 0;

                for(int k = 0 ; k<m ; k++) {
                    if(str.charAt(k) == '0') cnt0++;
                    else cnt1++;
                }

                if(cnt0 % 2 == 0 || cnt1 % 2 == 0) {
                    flag = false;
                    break;
                }
            }

            if(!flag) sb.append("#" + (i+1) + " no\n");
            else sb.append("#" + (i+1) + " yes\n");
        }
        System.out.println(sb);
    }
}
