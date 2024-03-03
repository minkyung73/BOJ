package boj.gold._1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class boj_17472 {
    // 다리 만들기 2
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 상하좌우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int islandNum;
    static int[] parents;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        init();
        divideIsland();
//        print();
        makeEdgeList();
//        for (Edge edge : edgeList) System.out.println(edge);
        System.out.println(kruskal());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        islandNum = 0;
        edgeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void divideIsland() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j, ++islandNum);
                }
            }
        }

        parents = new int[islandNum + 1];
        for (int i = 0; i <= islandNum; i++) parents[i] = i;
    }

    public static void BFS(int x, int y, int num) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = num;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void makeEdgeList() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M ; j++) {
                if(map[i][j] > 0) makeBridge(i, j, map[i][j]);
            }
        }
        Collections.sort(edgeList);
    }

    public static void makeBridge(int x, int y, int island) {

        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            while (true) {
                int nx = x + dx[i]*cnt;
                int ny = y + dy[i]*cnt;

                // 영역 밖이거나 같은 섬인 경우
                if(!checkRange(nx, ny) || map[nx][ny] == island) break;

                // 다른 섬에 도달했다면
                if(map[nx][ny] != 0) {
//                    if(island < map[nx][ny])
                    if(cnt-1 > 1)
                        edgeList.add(new Edge(island, map[nx][ny], cnt - 1));
                    break;
                }

                cnt++;
            }
        }
    }

    public static long kruskal() {
        long weight = 0;
        int cnt = 0;

        for (Edge edge : edgeList) {
            if(!union(edge.from, edge.to)) continue;

            weight += edge.weight;

            if(++cnt == islandNum-1) break;
        }

        // 공통 부모를 최종 갱신
        for (int i = 1 ; i <= islandNum ; i++)
            parents[i] = find(i);

        // 연결 안 된 다리가 있을 경우
        for (int i = 1 ; i <= islandNum ; i++){
            if(parents[i] != parents[1]) return -1;
        }

        return weight == 0 ? -1 : weight;
    }

    public static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        if(fromRoot == toRoot) return false;

        parents[toRoot] = parents[fromRoot];
        return true;
    }

    public static int find(int node) {
        if(parents[node] == node) return node;
        return parents[node] = find(parents[node]);
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
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

//        @Override
//        public int compareTo(Edge o) {
//            return this.from != o.from ? this.from - o.from : this.to - o.to;
//        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
