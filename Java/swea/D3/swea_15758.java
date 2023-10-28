package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_15758 {
    // 무한 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();

            sb.append("#" + (i+1) + " " + f(s, t) + "\n");
        }
        System.out.println(sb);
    }

    public static String f(String s, String t) {
        int lcm = lcm(s.length(), t.length());
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();

        for(int i=0 ; i<lcm/s.length() ; i++)
            s1.append(s);

        for(int i=0 ; i<lcm/t.length() ; i++)
            t1.append(t);

        if(s1.toString().equals(t1.toString())) return "yes";
        else return "no";
    }

    public static int lcm(int s_len, int t_len) {
        int gcd;

        if(s_len > t_len) gcd = gcd(s_len, t_len);
        else gcd = gcd(t_len, s_len);

        return (s_len * t_len) / gcd;
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
