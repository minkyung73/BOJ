package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1868 {
    // 파핑파핑 지뢰찾기
    static int n;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    static Queue<Node> queue = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            map = new String[n + 1][n + 1];
            visited = new boolean[n + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                String str = br.readLine();
                for (int k = 1; k <= n; k++) {
                    map[j][k] = String.valueOf(str.charAt(k-1));
                }
            }

        }

        // output
        System.out.println(sb);
    }

    public static void BFS(int x, int y) {
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

        }
    }

    public static boolean rangeCheck(int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
