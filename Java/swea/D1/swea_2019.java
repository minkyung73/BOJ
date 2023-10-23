package swea.D1;

import java.io.IOException;
import java.util.Scanner;

public class swea_2019 {
    // 더블더블

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int num = 1;
        for(int i=0 ; i<=n ; i++) {
            sb.append(num + " ");
            num *= 2;
        }
        System.out.println(sb);
    }
}
