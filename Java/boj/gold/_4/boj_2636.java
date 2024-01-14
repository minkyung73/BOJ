package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2636 {
    // 치즈

    /**
     * 초기 치즈 개수를 센다. -> cheese
     * 치즈 개수가 0이 될 때까지 반복한다. -> cheeseCount
     * BFS
     *  배열의 값이 0일 경우 queue.offer
     *  주변 탐색 시 1일 경우 cheese 개수를 줄인다.
     */

    static int n, m, cheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // initialize
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        cheese = 0;

        // map input
        // count cheese
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }

        // calculate cheeseCount and hour
        // function call - BFS
        int cheeseCount = 0, hour = 0;
        while (cheese != 0) {
            cheeseCount = cheese;
            visited = new boolean[n][m];
            hour++;
            BFS();
        }

        // output
        System.out.println(hour + "\n" + cheeseCount);
    }

    public static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny));
                    } else {
                        cheese--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
