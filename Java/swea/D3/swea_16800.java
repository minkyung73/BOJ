package swea.D3;

import java.io.IOException;
import java.util.Scanner;

public class swea_16800 {
    // 구구단 걷기

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            long n = sc.nextLong();
            long result = f(n);
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static long f(long n) {
        long min = n-1;
        long a, b;

        for(long i = 2 ; i<=Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                a = i;
                b = n / i;
                min = Math.min(min, ((a-1) + (b-1)));
            }
        }

        return min;
    }
}
