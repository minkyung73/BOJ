package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1961 {
    // 숫자 배열 회전
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            sb.append("#" + (i+1) + "\n");

            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            for(int j=0 ; j<n ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<n ; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=0 ; j<n ; j++) {
                rotate90(sb, j);
                rotate180(sb, j);
                rotate270(sb, j);
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }

    public static void rotate90(StringBuilder sb, int y) {
        for(int i = n-1 ; i>=0 ; i--)
            sb.append(arr[i][y]);
        sb.append(" ");
    }

    public static void rotate180(StringBuilder sb, int x) {
        x = n - x - 1;

        for(int i = n-1 ; i>=0 ; i--)
            sb.append(arr[x][i]);
        sb.append(" ");
    }

    public static void rotate270(StringBuilder sb, int y) {
        y = n - y - 1;

        for(int i = 0 ; i< n ; i++)
            sb.append(arr[i][y]);
        sb.append(" ");
    }
}
