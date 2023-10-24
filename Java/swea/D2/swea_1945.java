package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class swea_1945 {
    // 간단한 소인수분해
    private static int n;
    private static int[] arr = {2, 3, 5, 7, 11};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            sb.append("#" + (i+1) + " ");
            n = sc.nextInt();

            for(int j=0 ;j<5 ; j++) {
                sb.append(prime(arr[j]) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int prime(int p) {
        int cnt = 0;

        while (n % p == 0) {
            cnt++;
            n /= p;
        }

        return cnt;
    }
}
