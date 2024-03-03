package boj.gold._1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194_2 {
    // 달이 차오른다, 가자.
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static Point minsik;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(BFS());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') minsik = new Point(i, j);
            }
        }
    }

    public static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(minsik.x, minsik.y, 0, 0));
        visited[minsik.x][minsik.y][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

//            System.out.println(now.x + "," + now.y + "->" + now.key);

            if(map[now.x][now.y] == '1') return now.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny][now.key]) {
                    // 벽인 경우
                    if(map[nx][ny] == '#') continue;

                    // 빈칸, 0, 1인 경우
                    if(map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
                        queue.offer(new Node(nx, ny, now.cnt + 1, now.key));
                        visited[nx][ny][now.key] = true;
                    }

                    // 열쇠인 경우
                    if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                        int tempKey = now.key | (1 << (map[nx][ny] - 'a'));
                        queue.offer(new Node(nx, ny, now.cnt + 1, tempKey));
                        visited[nx][ny][tempKey] = true;
                    }

                    // 문인 경우
                    if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                        if((now.key & (1 << map[nx][ny] - 'A')) >= 1) {
                            queue.offer(new Node(nx, ny, now.cnt + 1, now.key));
                            visited[nx][ny][now.key] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Node {
        int x, y, cnt, key;

        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
