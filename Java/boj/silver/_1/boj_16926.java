package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926 {
    // 배열 돌리기 1
    static int n, m, r;
    static int[][] map;
    static int num;

    public static void main(String[] args) throws IOException{
        init();
        for(int i=0 ; i<r ; i++) rotate();
        print();
    }

    public static void rotate() {
        for(int i=0 ; i<num ; i++) {
            int temp = map[i][i];

            // rotate 1
            for(int j=i+1 ; j<m-i ; j++){
                map[i][j-1] = map[i][j];
            }

            // rotate 2
            for (int j = i+1; j < n-i; j++) {
                map[j-1][m-1-i] = map[j][m - 1 - i];
            }

            // rotate 3
            for (int j = m-2-i; j >= i ; j--) {
                map[n-1-i][j+1] = map[n-1-i][j];
            }

            // rotate 4
            for (int j = n-2-i; j >= i; j--) {
                map[j+1][i] = map[j][i];
            }

            //
            map[i+1][i] = temp;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반시계 방향으로 돌릴 사각형 개수
        num = Math.min(n, m) / 2;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
