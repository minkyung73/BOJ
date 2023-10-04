import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    // 체스판 다시 칠하기

    public static int min = 64;
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];

        for(int i= 0 ; i<n ; i++) {
            String str = br.readLine();

            for(int j=0 ; j<m ; j++) {
                if(str.charAt(j) == 'W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        int n_row = n-7;
        int m_row = m-7;

        for(int i=0 ; i<n_row ; i++) {
            for(int j=0 ; j<m_row ;j++) {
                chess(i, j);
            }
        }

        System.out.println(min);
    }

    public static void chess(int x, int y) {
        int end_x = x+8;
        int end_y = y+8;
        int count = 0;

        boolean TF = arr[x][y];
        for(int i=x ; i<end_x ; i++) {
            for(int j = y ; j<end_y ;j++) {
                if(arr[i][j] != TF) count++;
                TF = !TF;
            }
            TF = !TF;
        }

        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}
