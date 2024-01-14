package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16948 {
    // 데스 나이트
    static int n;
    static int r1, c1, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        BFS(r1, c1, 0);
    }

    public static void BFS(int x, int y, int depth) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, depth));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.x == r2 && now.y == c2) {
                System.out.println(now.depth);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny) && !visited[nx][ny]) {
                    queue.offer(new Node(nx, ny, now.depth + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x <= n && y >= 0 && y <= n;
    }

    public static class Node {
        int x, y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
