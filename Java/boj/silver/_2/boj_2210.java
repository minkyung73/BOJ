package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2210 {
    // 숫자판 점프
    private static int[][] arr = new int[5][5];
    private static int[] num = new int[6];
    private static boolean[][] visited = new boolean[5][5];
    private static List<String> list = new ArrayList<>();
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0 ; i<5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<5 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS
        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++) {
                DFS(i, j, 1);  // function call
            }
        }

        System.out.println(list.size());
    }

    public static void DFS(int x, int y, int depth) {

        if(depth > 6) {
            String str = "";
            for(int i=0 ; i<6 ; i++)
                str += String.valueOf(num[i]);

            if(!list.contains(str)) {
                list.add(str);
            }

            return ;
        }

        num[depth-1] = arr[x][y];

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny)) {
                DFS(nx, ny, depth+1);
            }
        }
    }

    public static boolean rangeCheck(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
