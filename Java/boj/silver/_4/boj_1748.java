package boj.silver._4;

import java.util.Scanner;

public class boj_1748 {
    // 수 이어 쓰기 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int n_digit = String.valueOf(n).length();

        int temp = 1;
        int temp_digit = 0;
        int result = 0;

        while (temp_digit < n_digit) {
            temp_digit++;

            if(temp_digit != n_digit) {
                temp *= 10;
                result += temp_digit * (temp - (temp/10));
            } else {
                temp = n;
                result += n_digit * (n - Math.pow(10, n_digit-1) + 1);
            }

        }

        System.out.println(result);
    }
}
