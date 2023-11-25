package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24444 {
    // 알고리즘 수업 - 너비 우선 탐색 1
    private static int n, m, r;
    private static ArrayList<Integer>[] graph;
    private static int[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // initialize graph
        graph = new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++) graph[i] = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i=1 ; i<=n ; i++) Collections.sort(graph[i]);

        // initialize visited
        visited = new int[n+1];
        for(int i=1 ; i<=n ; i++) visited[i] = 0;

        // function call
        BFS(r);

        for(int i=1 ; i<=n ; i++) sb.append(visited[i] + "\n");
        System.out.println(sb);
    }

    public static void BFS(int node) {
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = cnt++;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for(int i : graph[p]) {
                if(visited[i]==0) {
                    visited[i] = cnt++;
                    queue.offer(i);
                }
            }
        }

    }
}
