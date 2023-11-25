package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11724 {
    // 연결 요소의 개수
    private static int n, m;
    private static int[][] graph;
    private static boolean[] visit;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        // DFS
        for(int i=1 ; i<=n ; i++) {
            if(!visit[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }

    public static void DFS(int node) {
        visit[node] = true;

        for(int i = 1 ; i<=n ; i++) {
            if(i == node) continue;

            if(graph[node][i] == 1 && !visit[i])
                DFS(i);
        }
    }
}
