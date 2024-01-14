package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24445 {
    // 알고리즘 수업 - 너비 우선 탐색 2
    static int n, m, r;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        result = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        // function call
        BFS(r);

        // output
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result[now] = cnt++;

            // 내림차순 정렬
            Collections.sort(map.get(now), Collections.reverseOrder());

            for (int i : map.get(now)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
