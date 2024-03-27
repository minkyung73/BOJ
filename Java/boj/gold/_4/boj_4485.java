package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4485 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int size[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 1;

    public static void main(String[] args) throws IOException {

        while ( (n = Integer.parseInt(br.readLine())) != 0) {
            init();
            BFS();
            sb.append("Problem ").append(cnt++).append(": ").append(size[n - 1][n - 1]).append("\n");
        }

        System.out.println(sb);
    }

    public static void init() throws IOException {
        map = new int[n][n];
        visited = new boolean[n][n];
        size = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                size[i][j] = Integer.MAX_VALUE/4;
            }
        }
    }

    public static void BFS() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(0, 0, map[0][0]));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny)
                        && !visited[nx][ny]
                        && size[nx][ny] > (map[nx][ny] + now.val)) {
                    size[nx][ny] = (map[nx][ny] + now.val);
                    queue.offer(new Node(nx, ny, size[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x <n && y >= 0 && y < n;
    }

    public static class Node implements Comparable<Node> {
        int x, y, val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }
}
