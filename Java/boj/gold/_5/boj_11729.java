package boj.gold._5;

import java.io.IOException;
import java.util.Scanner;

public class boj_11729 {
    // 하노이 탑 이동 순서
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sb.append((int) Math.pow(2, n)-1 + "\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int destination) {
        if(n == 1) {
            sb.append(start + " " + destination + "\n");
            return ;
        }

        // n-1개를 a에서 b로 이동
        hanoi(n-1, start, destination, mid);

        // a에서 c로 이동
        sb.append(start + " " + destination + "\n");

        // b에서 c로 이동
        hanoi(n-1, mid, start, destination);
    }
}
