package boj.gold._4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_17406 {
    // 배열 돌리기 4
    static int n, m, k;
    static int[][] map, map_copy;
    static Operator[] op;
    static int result;
    static Operator[] selected;
    static boolean[] visited;
    static int square;

    public static void main(String[] args) throws IOException {
        init();
        permutation(0); // permutation -> rotate -> findResult
        System.out.println(result);
    }

    public static void permutation(int k) {
        // basis part
        if(k == selected.length) {
            // map_copy init
            map_copy = new int[n][m];
            for (int i = 0; i < n; i++) map_copy[i] = map[i].clone();

            // function call rotate
            for (int i = 0; i < k; i++) rotate(selected[i]);

            // function call findResult
            findResult();

            return ;
        }

        // inductive part
        for (int i = 0; i < op.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[k] = op[i];
                permutation(k+1);
                visited[i] = false;
            }
        }
    }

    public static void rotate(Operator sel) {
        Point start = new Point(sel.r - sel.s - 1, sel.c - sel.s - 1);
        Point end = new Point(sel.r + sel.s - 1, sel.c + sel.s - 1);

        // 시계방향 회전
        square = Math.min(Math.abs(start.x - end.x), Math.abs(start.y - end.y))/2;
        for (int i = 0; i < square; i++) {
            int temp = map_copy[start.x + i][end.y - i];

            // rotate 1
            for (int j = end.y - i-1; j >= start.y + i ; j--) {
                map_copy[start.x + i][j+1] = map_copy[start.x + i][j];
            }

            // rotate 2
            for (int j = start.x + i + 1; j <= end.x - i; j++) {
                map_copy[j-1][start.y + i] = map_copy[j][start.y + i];
            }

            // rotate 3
            for (int j = start.y + i + 1; j <= end.y - i; j++) {
                map_copy[end.x - i][j-1] = map_copy[end.x - i][j];
            }

            // rotate 4
            for (int j = end.x - i -1; j >= start.x + i ; j--) {
                map_copy[j+1][end.y-i] = map_copy[j][end.y - i];
            }

            //
            map_copy[start.x + 1 + i][end.y - i] = temp;
        }
    }

    public static void findResult() {
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += map_copy[i][j];
            }
            result = Math.min(result, temp);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //
        op = new Operator[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            op[i] = new Operator(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        //
        result = Integer.MAX_VALUE;
        selected = new Operator[k];
        visited = new boolean[k];
    }

    public static class Operator {
        int r, c, s;

        public Operator(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
