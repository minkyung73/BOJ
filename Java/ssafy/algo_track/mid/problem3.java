package ssafy.algo_track.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    // 숫자 배열 회전 (D2)
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            // arr input
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + (i + 1) + "\n");
            // rotate
            for (int j = 0; j < n; j++) {
                sb.append(rotate90(n, j) + " ");
                sb.append(rotate180(n, n-j-1) + " ");
                sb.append(rotate270(n, n-j-1) + "\n");
            }
        }

        // output
        System.out.println(sb);
    }

    public static String rotate90(int n, int y) {
        StringBuilder str = new StringBuilder();

        for (int i = n-1 ; i >= 0 ; i--)
            str.append(String.valueOf(arr[i][y]));

        return str.toString();
    }

    public static String rotate180(int n, int x) {
        StringBuilder str = new StringBuilder();

        for (int i = n-1 ; i >= 0 ; i--)
            str.append(String.valueOf(arr[x][i]));

        return str.toString();
    }

    public static String rotate270(int n, int y) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str.append(String.valueOf(arr[i][y]));
        }

        return str.toString();
    }
}
