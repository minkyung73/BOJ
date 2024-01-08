package ssafy.algo_track.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1 {
    // 파리퇴치3 (D2)
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            int max = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // calculate
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, straight(j, k));
                    max = Math.max(max, diagonal(j, k));
                }
            }

            // result
            sb.append("#" + (i + 1) + " " + max + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static int straight(int x, int y) {
        int res = arr[x][y];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        /**
         * 처음 위치 (0,0)
         * (-1,0), (1,0), (0,1), (0,-1)
         * (-2,0), (2,0), (0,2), (0,-2)
         */

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int nx, ny;

                if(j<2) {
                    nx = x + dx[j] * i;
                    ny = y + dy[j];
                } else {
                    nx = x + dx[j];
                    ny = y + dy[j] * i;
                }

                if(checkRange(nx, ny))
                    res += arr[nx][ny];
            }
        }

        return res;
    }

    public static int diagonal(int x, int y) {
        int res = arr[x][y];
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        /**
         * 처음 위치 (0,0)
         * (-1,1), (-1,-1), (1,-1), (1,1)
         * (-2,2), (-2,-2), (2,-2), (2,2)
         */

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;

                if (checkRange(nx, ny))
                    res += arr[nx][ny];
            }
        }

        return res;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
