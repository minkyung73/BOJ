package swea.D3;

import java.io.IOException;
import java.util.Scanner;

public class swea_16002 {
    // 합성수 방정식

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            long n = sc.nextLong();
            long x = 2;

            while (true) {
                if(f(x) && f(x+n)) break;
                x++;
            }

            sb.append("#" + (i+1) + " " + (x+n) + " " + x + "\n");
        }
        System.out.println(sb);
    }

    public static boolean f(long x) {
        for(int i=2 ; i<= Math.sqrt(x) ; i++) {
            if(x % i == 0) return true;
        }

        return false;
    }
}
