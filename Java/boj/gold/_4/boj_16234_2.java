package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16234_2 {

    public static int n, l, r;
    public static int[][] map;

    // 오른쪽, 아래
    public static final int[] dx = {0, 1};
    public static final int[] dy = {1, 0};

    public static int day = 0;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(day);

        HashMap<Integer, Integer> hash = new HashMap<>();


//        if(hash.containsKey())


        hash.put(2, hash.get(2) + 1);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void bfs() {

    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
