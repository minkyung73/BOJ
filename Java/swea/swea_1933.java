package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_1933 {
    // 간단한 N의 약수

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for(int i=1 ; i<=n ; i++) {
            if(n % i == 0) sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
