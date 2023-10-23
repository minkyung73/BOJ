package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class swea_1970 {
    // 쉬운 거스름돈
    private static int num;
    private static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            sb.append("#" + (i+1) + "\n");
            num = sc.nextInt();

            for(int j=0 ; j<8 ; j++) {
                sb.append(change(money[j]) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int change(int money) {
        int res = num / money;
        num -= money * res;

        return res;
    }
}
