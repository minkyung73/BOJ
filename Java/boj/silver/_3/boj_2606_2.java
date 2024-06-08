package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606_2 {

    public static int n, m;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    public static void init() throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }
    }

    public static int bfs() {
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int i = 1; i <= n; i++) {
                if(map[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
