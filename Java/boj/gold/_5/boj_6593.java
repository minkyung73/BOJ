package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6593 {
    // 상범 빌딩
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int L, R, C;
    static int[][][] building;
    static Point start, end;

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0) break;
            init();
            BFS();
        }

        System.out.println(sb);
    }

    public static void init() throws IOException {
        building = new int[L][R][C];

        /**
         * . : 0
         * # : 1
         * S : 2
         * E : 3
         */
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String str = br.readLine();
                for (int k = 0; k < C; k++) {
                    char c = str.charAt(k);
                    if(c == '.') building[i][j][k] = 0;
                    else if(c == '#') building[i][j][k] = 1;
                    else if(c == 'S') {
                        building[i][j][k] = 2;
                        start = new Point(i, j, k, 0);
                    }
                    else if(c == 'E') {
                        building[i][j][k] = 3;
                        end = new Point(i, j, k, 0);
                    }
                }
            }
            br.readLine();
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];

        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        queue.offer(start);
        visited[start.x][start.y][start.z] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

//            if (now.x == end.x && now.y == end.y && now.z == end.z) {
            if(now.equals(end)) {
                sb.append("Escaped in ").append(now.min).append(" minute(s).\n");
                return ;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if(checkRange(nx, ny, nz)
                        && !visited[nx][ny][nz]
                        && building[nx][ny][nz] != 1) {

                    queue.offer(new Point(nx, ny, nz, now.min + 1));
                    visited[nx][ny][nz] = true;
                }
            }
        }

        sb.append("Trapped!\n");
    }

    public static boolean checkRange(int x, int y, int z) {
        return x >= 0 && x < L
                && y >= 0 && y < R
                && z >= 0 && z < C;
    }

    public static class Point {
        int x, y, z;
        int min;

        public Point(int x, int y, int z, int min) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.min = min;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && z == point.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }


}
