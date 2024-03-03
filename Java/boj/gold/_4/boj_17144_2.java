package boj.gold._4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17144_2 {
    // 미세먼지 안녕!
    static int R, C, T;
    static int[][] map;
    static List<Point> airCleaner;  // 공기청정기

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < T; i++) {
            diffuse();
            clean();
        }
        System.out.println(result());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airCleaner = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) airCleaner.add(new Point(i, j));
            }
        }
    }

    public static void diffuse() {
        List<Dust> dustList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) {
                    dustList.add(new Dust(i, j, map[i][j]));
                    map[i][j] = 0;
                }
            }
        }

        //
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (Dust dust : dustList) {
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = dust.x + dx[i];
                int ny = dust.y + dy[i];

                if(checkRange(nx, ny) && map[nx][ny] != -1) {
                    map[nx][ny] += dust.d / 5;
                    cnt++;
                }
            }

            map[dust.x][dust.y] += (dust.d - (dust.d/5) * cnt);
        }
    }

    public static boolean checkRange(int x, int y) {
        return (x >= 0 && x < R && y >= 0 && y < C);
    }

    public static void clean() {
        // 위쪽 반시계 방향 순환
        Point cleaner1 = airCleaner.get(0);

        for (int i = cleaner1.x -2 ; i >= 0; i--)
            map[i+1][0] = map[i][0];

        for (int i = 1; i < C; i++)
            map[0][i-1] = map[0][i];

        for (int i = 1; i <= cleaner1.x; i++)
            map[i-1][C-1] = map[i][C-1];

        for (int i = C-2; i >= 1 ; i--)
            map[cleaner1.x][i+1] = map[cleaner1.x][i];

        map[cleaner1.x][1] = 0;

        // 아래쪽 시계 방향 순환
        Point cleaner2 = airCleaner.get(1);

        for (int i = cleaner2.x+2; i < R; i++)
            map[i-1][0] = map[i][0];

        for (int i = 1; i < C; i++)
            map[R-1][i-1] = map[R-1][i];

        for (int i = R-2 ; i>=cleaner2.x ; i--)
            map[i+1][C-1] = map[i][C-1];

        for (int i = C-2; i >= 1; i--)
            map[cleaner2.x][i+1] = map[cleaner2.x][i];

        map[cleaner2.x][1] = 0;

    }

    public static int result() {
        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) sum += map[i][j];
            }
        }

        return sum;
    }

    public static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Dust {
        int x, y, d;

        public Dust(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
