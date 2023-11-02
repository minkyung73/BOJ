package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_11688 {
    // Calkin-Wilf tree 1
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            a = 1;
            b = 1;

            calkin(str);
            sb.append("#" + (i+1) + " " + a + " " + b + "\n");
        }
        System.out.println(sb);
    }

    public static void calkin(String str) {

        for(int i=0 ; i<str.length() ; i++) {
            if(str.charAt(i) == 'L') b = a+b;
            if(str.charAt(i) == 'R') a = a+b;
        }
    }
}
