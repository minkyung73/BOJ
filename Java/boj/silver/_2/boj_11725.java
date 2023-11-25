package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11725 {
    // 트리의 부모 찾기
    private static int n;
    private static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    private static boolean[] visited;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parents = new int[n+1];

        for(int i=0 ; i<=n ; i++)
            edges.add(new ArrayList<>());

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.get(u).add(v);
            edges.get(v).add(u);
        }

//        System.out.println(edges);

        DFS(1);

        for(int i=2 ; i<parents.length ; i++) {
            System.out.println(parents[i]);;
        }
    }

    private static void DFS(int node) {
        visited[node]  = true;

        int size = edges.get(node).size();

        for(int i=0 ; i<size ; i++) {
            int v = edges.get(node).get(i);
            if(!visited[v]) {
                DFS(v);
                parents[v] = node;
            }
        }
    }
}
