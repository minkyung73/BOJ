package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_10570 {
    // 제곱 팰린드롬 수
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for(int j=a ; j<=b ; j++) {
                if(Math.pow((int) Math.sqrt(j), 2) != j)
                    continue;

                if(palindrome(j) && palindrome((int)Math.sqrt(j)))
                    cnt++;
            }

            sb.append("#" + (i+1) + " " + cnt + "\n");
        }
        System.out.println(sb);
    }

    public static boolean palindrome(int num) {
        String str = String.valueOf(num);

        for(int i=0 ; i<str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }

        return true;
    }
}
