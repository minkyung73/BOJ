package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1824 {
    // 혁진이의 프로그램 검증
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            init();
        }
        System.out.println(sb);
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }


}
