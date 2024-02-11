package swea.D4;

import java.util.*;
import java.io.*;

public class swea_7699 {
    // 수지의 수지 맞는 여행
    static int r, c;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] alphabet;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            init(br);
            DFS(0, 0, 1);
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y, int cnt) {
        alphabet[map[x][y]] = true;
        result = Math.max(result, cnt);

        if(result == 26) return ;   // 최적화

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(checkRange(nx, ny) && !alphabet[map[nx][ny]]){
                DFS(nx, ny, cnt+1);
            }
        }
        alphabet[map[x][y]] = false;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    public static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        alphabet = new boolean[27];
        result = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++)
                map[i][j] = str.charAt(j) - 64; // A가 1, Z가 26
        }
    }
}
