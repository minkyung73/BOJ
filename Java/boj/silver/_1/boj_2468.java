package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2468 {
    // 안전 영역
    private static int n, result = 0, max = 0, cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        // DFS
        for(int i=0 ; i<max ; i++) {
            visited = new boolean[n][n];
            cnt = 0;

            for(int j=0 ; j<n ; j++) {
                for(int k=0 ; k<n ; k++) {
                    if(!visited[j][k] && map[j][k] > i) {
                        DFS(j, k, i);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    public static void DFS(int x, int y, int height) {
        visited[x][y] = true;

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] > height) {
                DFS(nx, ny, height);
            }
        }
    }

    public static boolean rangeCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
