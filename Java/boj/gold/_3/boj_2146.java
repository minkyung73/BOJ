package boj.gold._3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {
    // 다리 만들기
    static int n;
    static int[][] map, district;
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result;

    public static void main(String[] args) throws IOException{
        init();

        // 섬 구역 나누기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) island(i, j);
            }
        }

        // 가장 짧은 다리 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isSurround(i, j) || map[i][j] == 0) continue;

                visited = new boolean[n][n];
                bridge(i, j);
            }
        }

        System.out.println(result);
    }

    private static void bridge(int x, int y) {
        int district = map[x][y];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 다른 섬에 도착한 거라면
            if(map[now.x][now.y] != 0 && map[now.x][now.y] != district) {
                result = Math.min(result, now.cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny]
                    && map[nx][ny] != district) {

                    int temp = map[nx][ny] == 0 ? now.cnt + 1 : now.cnt;
                    queue.offer(new Node(nx, ny, temp));
                    visited[nx][ny] = true;
                }
            }
        } // end of while
    }

    public static boolean isSurround(int x, int y) {
        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(checkRange(nx, ny) && map[nx][ny] != map[x][y])
                return false;
        }

        return true;
    }

    private static void island(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = ++cnt;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = cnt;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        district = new int[n][n];
        visited = new boolean[n][n];
        cnt = 0;
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
