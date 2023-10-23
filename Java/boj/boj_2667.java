package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2667 {
    // 단지 번호 붙이기

    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dir_X = {0, 0, -1, 1};
    private static int[] dir_Y = {1, -1, 0, 0};
    private static int now_X, now_Y;
    private static int complex=0; // 단지 수
    private static int house; //  단지 별 가구 수
    private static List<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // DFS
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    complex++;
                    house = 0;
                    DFS(i, j);
                    houses.add(house);
                }
            }
        }
        Collections.sort(houses);

        // output
        System.out.println(complex);
        for (Integer h : houses)
            System.out.println(h);
    }

    public static void DFS(int x, int y) {
        visit[x][y] = true;
        house++;

        for(int i=0 ; i<4 ; i++) {
            now_X = x + dir_X[i];
            now_Y = y + dir_Y[i];

            if(rangeCheck() && map[now_X][now_Y] == 1 && !visit[now_X][now_Y])
                DFS(now_X, now_Y);
        }
    }

    public static boolean rangeCheck() {
        return now_X >= 0 && now_X < n
                && now_Y >= 0 && now_Y < n;
    }
}
