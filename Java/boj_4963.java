import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4963 {
    // 섬의 개수
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dir_X = {-1, 0, 1};
    private static int[] dir_Y = {-1, 0, 1};
    private static int now_X, now_Y;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visit = new boolean[h][w];

            for(int i=0 ; i<h ; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0 ; j<w ; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }

            // DFS
            cnt = 0;
            for(int i=0 ; i<h ; i++) {
                for(int j=0 ; j<w ; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        visit[x][y] = true;

        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                now_X = x + dir_X[i];
                now_Y = y + dir_Y[j];

                if(x == now_X && y == now_Y) continue;

                if(rangeCheck() && map[now_X][now_Y] == 1 && !visit[now_X][now_Y])
                    DFS(now_X, now_Y);
            }
        }
    }

    public static boolean rangeCheck() {
        return now_X >= 0 && now_X < h
            && now_Y >= 0 && now_Y < w;
    }
}
