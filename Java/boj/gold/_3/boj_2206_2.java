package boj.gold._3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_2 {
    // 벽 부수고 이동하기
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        BFS();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
    }

    public static void BFS() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.x == N-1 && now.y == M-1) {
                result = Math.min(result, now.cnt);
                return ;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny)) {
                    if(map[nx][ny] == 0 && !visited[nx][ny][now.wall]) {
                        queue.offer(new Node(nx, ny, now.wall, now.cnt+1));
                        visited[nx][ny][now.wall] = true;
                    } else if(map[nx][ny] == 1 && now.wall == 0) {
                        queue.offer(new Node(nx, ny, 1, now.cnt + 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Node {
        int x, y, wall, cnt;

        public Node(int x, int y, int wall, int cnt) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }
}
