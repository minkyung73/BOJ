package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_15230 {
    // 알파벳 공부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            sb.append("#" + (i+1) + " " + alpha(str) + "\n");
        }
        System.out.println(sb);
    }

    public static int alpha(String str) {
        int num = 'a', cnt = 0;

        for(int i=0 ; i<str.length() ; i++) {
            if((int) str.charAt(i) == num) {
                cnt++;
                num++;
            }
            else break;
        }

        return cnt;
    }
}
