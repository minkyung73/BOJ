package swea.D3;

import java.io.IOException;
import java.util.Scanner;

public class swea_15941 {
    // 평행사변형

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int n = sc.nextInt();
            sb.append("#" + (i+1) + " " + (int) Math.pow(n, 2) + "\n");
        }
        System.out.println(sb);
    }
}
