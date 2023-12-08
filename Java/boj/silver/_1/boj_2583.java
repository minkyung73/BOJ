package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2583 {
    // 영역 구하기
    private static int m, n, k, cnt = 0, square;
    private static int map[][];
    private static boolean visited[][];
    private static List<Integer> list = new ArrayList<>();
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1 ; j<x2 ; j++) {
                for(int k=y1 ; k<y2 ; k++) {
                    map[j][k] = 1;
                }
            }
        }

//        for(int i=0 ; i<n ; i++) {
//            for(int j=0 ; j<m ; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        // DFS
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    square = 0;
                    DFS(i, j);
                    cnt++;
                    list.add(square);
                }
            }
        }

        Collections.sort(list);
        for (Integer i : list) sb.append(i + " ");

        System.out.println(cnt);
        System.out.println(sb);

    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        square++;

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                DFS(nx, ny);
            }
        }
    }

    public static boolean rangeCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
