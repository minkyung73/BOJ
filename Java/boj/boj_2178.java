package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
    // 미로 탐색

    private static int n, m, cnt = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dir_X = {0, 0, -1, 1};
    private static int[] dir_Y = {-1, 1, 0, 0};
    private static int next_X, next_Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            for(int j=0 ;j <m ; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // DFS
        visited[0][0] = true;
        BFS(0, 0);

        System.out.println(map[n-1][m-1]);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0 ; i<4 ; i++) {
                next_X = nowX + dir_X[i];
                next_Y = nowY + dir_Y[i];

                if(rangeCheck() && !visited[next_X][next_Y] && map[next_X][next_Y] == 1) {
                    queue.add(new int[] {next_X, next_Y});
                    map[next_X][next_Y] = map[nowX][nowY] + 1;
                    visited[next_X][next_Y] = true;
                }
            }
        }
    }

    public static boolean rangeCheck() {
        return next_X >= 0 && next_X < n
                && next_Y >= 0 && next_Y < m;
    }
}
