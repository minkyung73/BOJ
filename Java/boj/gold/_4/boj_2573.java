package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // initialize
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        // map input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // calculate
        int year = 0;
        while (true) {
            int cnt = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        BFS(i, j);  // function call
                        cnt++;
                    }
                }
            }

            if (cnt > 1) {
                System.out.println(year);
                break;
            } else if(cnt == 0) {
                System.out.println(0);
                break;
            } else {
                year++;
            }
        }

    }

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        if(map[now.x][now.y]>0)
                            map[now.x][now.y]--;
                    } else {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
