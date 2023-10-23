package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class swea_2005 {
    // 파스칼의 삼각형

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int n = sc.nextInt();

            sb.append("#" + (i+1) + "\n");
            sb.append(pascal(n));
        }
        System.out.println(sb);
    }

    public static StringBuilder pascal(int n) {
        StringBuilder sb = new StringBuilder();
        int[] pre_arr = new int[n+2];
        int[] cur_arr = new int[n+2];

        pre_arr[0] = 0;
        pre_arr[1] = 1;
        pre_arr[2] = 0;
        sb.append("1\n");

        for(int i=2 ; i<=n ; i++) {

            cur_arr[0] = 0;
            cur_arr[i+1] = 0;
            for(int j=1 ; j<=i ; j++) {
                cur_arr[j] = pre_arr[j-1] + pre_arr[j];
                sb.append(cur_arr[j] + " ");
            }

            pre_arr = cur_arr.clone();

            sb.append("\n");
        }

        return sb;
    }
}
