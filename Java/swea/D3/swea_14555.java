package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_14555 {
    // 공과 잡초

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            sb.append("#" + (i+1) + " " + ball(str) + "\n");
        }
        System.out.println(sb);
    }

    public static int ball(String str) {
        int cnt = 0;
        Stack<String> st = new Stack<>();

        for(int i=0 ; i<str.length() ; i++) {
            if(str.charAt(i) == '(' &&
                    (str.charAt(i+1) == '|' || str.charAt(i+1) == ')'))
                cnt++;
            else if(str.charAt(i) == ')' && str.charAt(i-1) == '|')
                cnt++;
        }

        return cnt;
    }
}
