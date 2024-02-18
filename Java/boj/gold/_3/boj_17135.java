package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17135 {
    // 캐슬 디펜스
    static int n, m, d;
    static int[][] map, copy;
    static int[] archers;
    static int result;


    public static void main(String[] args) throws IOException{
        init();
        combination(0, 0);
        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = copy = new int[n][m];
        archers = new int[3];
        result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void combination(int idx, int k) {
        // basis part
        if(k == 3) {
            copyMap();
            result = Math.max(result, war());
            return ;
        }

        // inductive part
        for(int i=idx ; i<m ; i++) {
            archers[k] = i;
            combination(i+1, k+1);
            archers[k] = 0;
        }

    }

    public static void copyMap() {
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
    }

    public static int war() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += attack();
            updateMap();
        }

        return cnt;
    }

    public static int attack() {
        int cnt = 0;
        List<Enemy> list = new ArrayList<>();

        // 각 궁수가 처치할 적 리스트 구하기 (중복 허용)
        for (int i = 0; i < 3; i++) {
            Enemy enemy = getEnemy(n, archers[i]);
            if(enemy != null) list.add(enemy);
        }

        // copy 에서 적 삭제
        for (Enemy enemy : list) {
            int x = enemy.x;
            int y = enemy.y;

            if(copy[x][y] == 1) {
                copy[x][y] = 0;
                cnt++;
            }
        }

        return cnt;
    }

    public static Enemy getEnemy(int x, int y) {
        Queue<Enemy> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // 좌, 상, 우
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        queue.offer(new Enemy(x-1, y, 1));

        while (!queue.isEmpty()) {
            Enemy now = queue.poll();

            if(copy[now.x][now.y] == 1) return now;

            for (int i = 0; i < 3; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && now.dist < d) {

                    queue.offer(new Enemy(nx, ny, now.dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return null;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void updateMap() {
        for (int i = n-1; i >=1 ; i--) {
            copy[i] = copy[i-1].clone();
        }
        copy[0] = new int[m];
    }

    public static class Enemy {
        int x, y, dist;

        public Enemy(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Enemy{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dist=" + dist +
                    '}';
        }
    }
}
