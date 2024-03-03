package boj.gold._3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class boj_17135_2 {
    // 캐슬 디펜스
    static int N, M, D;
    static int[][] map, copy;
    static int[] archers;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0);
        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];
        archers = new int[3];
        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void combination(int idx, int k) {
        // basis part
        if(k == 3) {
            war();
            return ;
        }

        if(idx == M) return ;

        // inductive part
        archers[k] = idx;
        combination(idx + 1, k + 1);
        combination(idx + 1, k);
    }

    public static void war() {
        // map copy
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();

        int cnt = 0;
        while (isEnemies()) {
            // 적군 처치
            List<Point> enemies = getEnemies();
            for (Point enemy : enemies) {
                if (copy[enemy.x][enemy.y] == 0) continue;
                copy[enemy.x][enemy.y] = 0;
                cnt++;
            }

            // 적군 전진
            for (int i = N - 1; i > 0; i--) copy[i] = copy[i - 1].clone();
            copy[0] = new int[M];
        }

        result = Math.max(result, cnt);
    }
    
    public static List<Point> getEnemies() {
        List<Point> enemies = new ArrayList<>();
        
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        for (int archer : archers) {
            int ax = N-1;
            int ay = archer;

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][M];

            queue.offer(new Node(ax, ay, 1));
            visited[ax][ay] = true;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if(copy[now.x][now.y] == 1) {
                    enemies.add(new Point(now.x, now.y));
                    break;
                }

                for (int i = 0; i < 3; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(checkRange(nx, ny) && !visited[nx][ny] && now.d < D) {
                        queue.offer(new Node(nx, ny, now.d+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return enemies;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static boolean isEnemies() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 1) return true;
            }
        }
        return false;
    }

    public static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
