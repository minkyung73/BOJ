package boj.bronze._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4153 {
    // 직각삼각형

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a=1, b=1, c=1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;

            int n1, n2, max;
            max = Math.max(a, b);
            max = Math.max(max, c);

            if(max == a) {
                n1 = b;
                n2 = c;
            } else if(max == b) {
                n1 = a;
                n2 = c;
            } else {
                n1 = a;
                n2 = b;
            }

            if(Math.pow(n1, 2) + Math.pow(n2, 2) == Math.pow(max, 2))
                System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
