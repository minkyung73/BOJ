import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    // 토마토

    private static int N, M, cnt = 0, result = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int nx, ny;
    private static boolean flag;
    private static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<M ; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Tomato(i, j));
                    visited[i][j] = true;
                }
            }
        }
        result = BFS();

        // map에 0이 남아 있는지 확인
        flag = true;
        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<M ; j++) {
                if(map[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }

        // output
        if(flag) System.out.println(result);
        else System.out.println(-1);
    }

    public static int BFS() {
        cnt = 0;

        while (!queue.isEmpty()) {
            flag = false;
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {
                Tomato now = queue.poll();

                for(int j=0 ; j<4 ; j++) {
                    nx = now.x + dx[j];
                    ny = now.y + dy[j];
                    flag = true;

                    if(rangeCheck() && map[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.add(new Tomato(nx, ny));
                        map[nx][ny] = 1;
                        visited[nx][ny] = true;
                    }
                }
            }
            cnt++;
        }

        return cnt-1;
    }

    public static boolean rangeCheck() {
        return nx >= 0 && nx < N
                && ny >= 0 && ny < M;
    }

    public static class Tomato {
        int x, y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
