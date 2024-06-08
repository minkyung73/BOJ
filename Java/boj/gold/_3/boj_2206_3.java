package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_3 {

    public static int n, m;
    public static int[][] map;
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
    }

    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][2];

        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.x == n-1 && now.y == m-1) {
                result = Math.min(result, now.cnt);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny][now.chk]) {
                    if(map[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny, now.cnt+1, now.chk));
                        visited[nx][ny][now.chk] = true;
                    }
                    else {
                        if(now.chk == 0) {
                            queue.offer(new Point(nx, ny, now.cnt+1, 1));
                            visited[nx][ny][now.chk] = true;
                        }
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Point {
        int x, y, cnt, chk;

        public Point(int x, int y, int cnt, int chk) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.chk = chk;
        }
    }
}
