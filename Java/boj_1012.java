import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1012 {
    // 유기농 배추

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr;

        for(int i=0 ; i<t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 배추가 있는 좌표 입력
            arr = new int[m][n];
            for(int j=0 ; j<k ; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            // function call
            int ans = cabbage(arr, m, n);
            System.out.println(ans);
        }
    }

    public static int cabbage(int[][] arr, int m, int n) {
        int cnt = 0;
        boolean[][] organic = new boolean[m][n];

        // init
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++)
                organic[i][j] = false;
        }

        // counting
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(arr[i][j] == 1)
                    recur(arr, organic, i, j);
            }
        }

        return cnt;
    }

    public static void recur(int[][] arr, boolean[][] organic, int x, int y) {

    }
}
