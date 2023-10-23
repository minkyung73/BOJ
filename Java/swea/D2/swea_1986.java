package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class swea_1986 {
    // 지그재그 숫자

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int num = sc.nextInt();
            int sum = 0;

            for(int j=1 ; j<=num ; j++) {
                if(j%2 == 1) sum += j;
                else sum -= j;
            }
            sb.append("#" + (i+1) + " " + sum + "\n");
        }
        System.out.print(sb);
    }
}
