package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600_2 {
    // 말이 되고픈 원숭이
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(BFS());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int BFS() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.x == H-1 && now.y == W-1) return now.cnt;

            // 원숭이
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny][now.horse]) {
                    queue.offer(new Node(nx, ny, now.horse, now.cnt + 1));
                    visited[nx][ny][now.horse] = true;
                }
            }

            if(now.horse == K) continue;

            // 말
            for (int i = 0; i < 8; i++) {
                int nx = now.x + hx[i];
                int ny = now.y + hy[i];

                if(checkRange(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny][now.horse+1]) {
                    queue.offer(new Node(nx, ny, now.horse + 1, now.cnt + 1));
                    visited[nx][ny][now.horse+1] = true;
                }
            }
        }

        return -1;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static class Node {
        int x, y, horse, cnt;

        public Node(int x, int y, int horse, int cnt) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.cnt = cnt;
        }
    }
}
