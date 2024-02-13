package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7465 {
    // 창용 마을 무리의 개수
    static int n, m;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n+1][n+1];
            visited = new boolean[n+1];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                map[u][v] = map[v][u] = 1;
            }

            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(!visited[j]) {
                    DFS(j);
                    cnt++;
                }
            }

            sb.append("#" + (i + 1) + " " + cnt + "\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if(map[node][i] == 1 && !visited[i])
                DFS(i);
        }
    }
}
