package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24479 {
    // 알고리즘 수업 - 깊이 우선 탐색 1
    private static int n, m, r, cnt = 1;
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        result = new int[n+1];
        for(int i=0 ; i<=n ; i++)
            list.add(new ArrayList<>());

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i=1 ; i<=n ; i++)
            Collections.sort(list.get(i));

        DFS(r); // function call

        for(int i=1 ; i<=n ; i++)
            sb.append(result[i] + "\n");

        System.out.println(sb);
    }

    public static void DFS(int node) {
        visited[node] = true;
        result[node] = cnt;
        cnt++;

        while (!list.get(node).isEmpty()) {
            int num = list.get(node).remove(0);
            if(!visited[num])
                DFS(num);
        }
    }
}
