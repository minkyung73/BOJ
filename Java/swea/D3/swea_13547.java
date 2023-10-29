package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_13547 {
    // 팔씨름

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ;i<T ; i++) {
            String str = br.readLine();
            int cnt = 0;

            for(int j=0 ; j<str.length() ; j++)
                if(str.charAt(j) == 'x') cnt++;

            if(cnt > 7) sb.append("#" + (i+1) + " NO\n");
            else sb.append("#" + (i+1) + " YES\n");
        }
        System.out.println(sb);
    }
}
