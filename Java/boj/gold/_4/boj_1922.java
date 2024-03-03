package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1922 {
    // 네트워크 연결
    static int N, M;
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(kruskal());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edgeList = new Edge[M];
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) parents[i] = i;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }
        Arrays.sort(edgeList);
    }

    public static long kruskal() {
        int cnt = 0;
        long weight = 0;

        for (Edge edge : edgeList) {
            if(!union(edge.from, edge.to)) continue;
            weight += edge.weight;
            if(++cnt == N-1) break;
        }

        return weight;
    }

    public static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        if(fromRoot == toRoot) return false;
        parents[toRoot] = fromRoot;
        return true;
    }

    public static int find(int node) {
        if(node == parents[node]) return node;
        return parents[node] = find(parents[node]);
    }

    public static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
