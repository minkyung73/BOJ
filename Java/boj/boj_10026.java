package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026 {
    // 적록색약
    private static int n, cnt=0;
    private static String[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // input
        arr = new String[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            String temp = br.readLine();
            for(int j=1 ; j<=n ; j++) {
                arr[i][j] = String.valueOf(temp.charAt(j-1));
            }
        }

        // function call
        // 1 - normal
        cnt = 0;
        visited = new boolean[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(!visited[i][j]){
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt + " ");

        // 2 - red-green
        cnt = 0;
        visited = new boolean[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(arr[i][j].equals("G"))
                    arr[i][j] = "R";
            }
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(!visited[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);

        // output
        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        String cur = arr[x][y];

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && !visited[nx][ny] && cur.equals(arr[nx][ny])){
                DFS(nx, ny);
            }
        }
    }

    public static boolean rangeCheck(int nx, int ny) {
        return (nx > 0 && nx <= n) &&
                (ny > 0 && ny <= n);
    }
}
