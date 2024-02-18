package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600 {
    // 말이 되고픈 원숭이
    static int k, w, h;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(BFS());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int BFS() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] hx = {-2,-1,1,2,2,1,-1,-2};
        int[] hy = {1,2,2,1,-1,-2,-2,-1};

        Queue<Monkey> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[h][w][k+1];

        queue.offer(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Monkey now = queue.poll();

            if(now.x == h-1 && now.y == w-1) return now.cnt;

            // 원숭이
            for(int i=0 ; i<4 ; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny][now.jump] && map[nx][ny] == 0) {
                    queue.offer(new Monkey(nx, ny, now.cnt + 1, now.jump));
                    visited[nx][ny][now.jump] = true;
                }
            }

            // 이미 말처럼 이동을 다 한 상태이면 continue
            if(now.jump == k) continue;

            // 말
            for (int i = 0; i < 8; i++) {
                int nx = now.x + hx[i];
                int ny = now.y + hy[i];

                // 점프 횟수 조건 추가
                if(checkRange(nx, ny) && !visited[nx][ny][now.jump+1] && map[nx][ny] == 0) {
                    queue.offer(new Monkey(nx, ny, now.cnt + 1, now.jump + 1));
                    visited[nx][ny][now.jump + 1] = true;
                }
            }
        }

        return -1;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    public static class Monkey {
        int x, y, cnt, jump;

        public Monkey(int x, int y, int cnt, int jump) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.jump = jump;
        }
    }
}
