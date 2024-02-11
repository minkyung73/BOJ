package swea.D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7733 {
    // 치즈 도둑
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max_day;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            init(br);
            for(int j=1 ; j<= max_day ; j++) findMaxPiece(j);
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void findMaxPiece(int day) {
        visited = new boolean[n][n];
        int cnt = 0;    // 덩어리 개수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] > day) {
                    BFS(i, j, day);
                    cnt++;
                }
            }
        }

        result = Math.max(result, cnt);
    }

    public static void BFS(int x, int y, int day) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] > day) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void init(BufferedReader br) throws IOException{
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        max_day = 0;
        result = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max_day = Math.max(max_day, map[i][j]);
            }
        }
    }
}
