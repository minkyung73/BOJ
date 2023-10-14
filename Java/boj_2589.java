import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {
    // 보물섬
    private static int W, H;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dir_X = {-1, 1, 0, 0};
    private static int[] dir_Y = {0, 0, -1, 1};
    private static int nextX, nextY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W];

        for(int i=0 ; i<H ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<W ; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // BFS
        int max = 0;

        for(int i=0 ; i<H ; i++) {
            for(int j=0 ; j<W ; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[H][W];
                    max = Math.max(max, BFS(i, j));
                }
            }
        }

        System.out.println(max);
    }

    public static int BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        int max = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                nextX = now.x + dir_X[i];
                nextY = now.y + dir_Y[i];

                if(rangeCheck()
                        && !visited[nextX][nextY]
                        && map[nextX][nextY] == 'L') {

                    queue.add(new Node(nextX, nextY, now.cnt + 1));
                    visited[nextX][nextY] = true;
                    max = Math.max(max, now.cnt + 1);
                }
            }
        }

        return max;
    }

    public static boolean rangeCheck() {
        return nextX >= 0 && nextX < H
                && nextY >= 0 && nextY < W;
    }

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
