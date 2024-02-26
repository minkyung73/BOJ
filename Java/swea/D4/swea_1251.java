package swea.D4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_1251 {
    // [S/W 문제해결 응용] 4일차 - 하나로
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static double E;
    static List<List<Edge>> list;
    static List<Point> island;
    static double[] minWeight;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            init();
            print();
            double result = Math.round(prim());
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void print() {
        for (List<Edge> edges : list) {
            for (Edge edge : edges) {
                System.out.println(edge);
            }
            System.out.println("======================");
        }
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        island = new ArrayList<>();
        minWeight = new double[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) minWeight[i] = Integer.MAX_VALUE;

        int[] axisX = new int[N];
        int[] axisY = new int[N];

        // X 좌표
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) axisX[i] = Integer.parseInt(st.nextToken());

        // Y 좌표
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) axisY[i] = Integer.parseInt(st.nextToken());

        // get island
        for (int i = 0; i < N; i++) island.add(new Point(axisX[i], axisY[i]));

        // 간선 가중치
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());

            for (int j = 0; j < N; j++) {
                double weight = getWeight(island.get(i), island.get(j));
                list.get(i).add(new Edge(j, weight));
            }
        }

        // 환경 부담금
        E = Double.parseDouble(br.readLine());
    }

    public static double getWeight(Point a, Point b) {
//        double L = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
//        return E * Math.pow(L, 2);
        double L2 = Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
        return E * L2;
    }

    public static double prim() {
        double weightSum = 0;
        minWeight[0] = 0;
        int cnt = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if(visited[now.idx]) continue;

            visited[now.idx] = true;
            weightSum += now.weight;
            if(++cnt == N) break;

            for (Edge edge : list.get(now.idx)) {
                if (!visited[edge.idx] && edge.weight < minWeight[edge.idx]) {
                    minWeight[edge.idx] = edge.weight;
                    queue.offer(new Edge(edge.idx, edge.weight));
                }
            }
        }

        return weightSum;
    }

    public static class Edge implements Comparable<Edge> {
        int idx;
        double weight;

        public Edge(int idx, double weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "idx=" + idx +
                    ", weight=" + weight +
                    '}';
        }
    }
}
