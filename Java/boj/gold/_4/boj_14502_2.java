package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14502_2 {

    public static int n, m;
    public static int[][] map;
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static List<Point> emptyList = new ArrayList<>();
    public static List<Point> virusList = new ArrayList<>();
    public static int[] selected = new int[3];

    public static int[][] copyMap;

    public static int initSafeRange = 0;
    public static int maxSafeRange = 0;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0);
        System.out.println(maxSafeRange);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    emptyList.add(new Point(i, j));
                    initSafeRange++;
                }
                if(map[i][j] == 2) virusList.add(new Point(i, j));
            }
        }

        // 무조건 벽을 3개 세우므로 안전영역이 3개 줄어듦
        initSafeRange = initSafeRange - 3;
    }

    public static void combination(int idx, int k) {
        // basis part
        if(k == 3) {
//            System.out.println(Arrays.toString(selected));
            copy();
            bfs();
//            print();    // test
            return ;
        }

        // inductive part
        for (int i = idx; i < emptyList.size(); i++) {
            selected[k] = i;
            combination(i+1, k+1);
        }
    }

    public static void print() {
        if(selected[0] == 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(copyMap[i]));
            }
        }
        System.out.println("ㄴ 현재 안전 영역: " + maxSafeRange);
    }

    public static void copy() {
        copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < 3; i++) {
            int idx = selected[i];
            Point emp = emptyList.get(idx);
            copyMap[emp.x][emp.y] = 1;
        }
    }

    public static void bfs() {
        int warningRange = 0;
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for (Point virus : virusList) {
            queue.offer(virus);
            visited[virus.x][virus.y] = true;
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && copyMap[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    warningRange++;
                }
            }
        }

//        System.out.println("warningRange: " + warningRange);
//        System.out.println("currentSafeRange: " + (initSafeRange - warningRange));
//        System.out.println();

        // update maxSafeRange
        maxSafeRange = Math.max(maxSafeRange, initSafeRange - warningRange);
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
