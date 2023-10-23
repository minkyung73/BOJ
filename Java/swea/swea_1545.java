package swea;

import java.io.IOException;
import java.util.Scanner;

public class swea_1545 {
    // 거꾸로 출력해 보아요

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for(int i = n ; i>=0 ; i--) sb.append(i + " ");

        System.out.println(sb);
    }
}
