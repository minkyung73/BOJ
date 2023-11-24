package boj.silver._5;

import java.io.IOException;
import java.util.Scanner;

public class boj_9655 {
    // 돌 게임

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}
