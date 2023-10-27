package swea.D3;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class swea_16910 {
    // 원 안의 점

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int N = sc.nextInt();
            int result = cntDot(N);
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static int cntDot(int n) {
        int cnt = 0;
        int dirX = -1*n, dirY = -1*n;

        for(int i=dirX ; i<=n ; i++) {
            for(int j=dirY ; j<=n ; j++) {
                if(Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2)) <= n)
                    cnt++;
            }
        }

        return cnt;
    }
}
