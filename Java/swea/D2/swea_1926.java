package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class swea_1926 {
    // 간단한 369 게임

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for(int i=1 ; i<=n ; i++) {
            String str = String.valueOf(i);
            boolean is369 = false;

            for(int j=0 ; j<str.length() ; j++) {
                if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    sb.append("-");
                    is369 = true;
                }
            }

            if(is369) sb.append(" ");
            else sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
