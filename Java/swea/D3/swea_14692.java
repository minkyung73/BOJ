package swea.D3;

import java.io.IOException;
import java.util.Scanner;

public class swea_14692 {
    // 통나무 자르기

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int n = sc.nextInt();
            String result = n % 2 == 0 ? "Alice" : "Bob";
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }
}
