package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389 {
    // 케빈 베이컨의 6단계 법칙
    private static int n, m;
    private static int[][] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        // initialize visited
        visited = new int[n+1];

        int min = 10000, result = 0;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++)
                visited[j] = 0; // initialize visited

            int bfs = BFS(i);   // function call
            if(bfs < min) {
                min = bfs;
                result = i;
            }
        }

        // output
        System.out.println(result);
    }

    public static int BFS(int node) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = 0;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for(int i=1 ; i<=n ; i++) {
                if(graph[p][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[p] + 1;
                    queue.offer(i);
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            if(i == node) continue;
            cnt += visited[i];
        }

        return cnt;
    }
}
