package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18352 {
    // 특정 거리의 도시 찾기
    private static int n, m, k, x;
    private static int cnt = 0;
//    private static int[][] graph;
    private static ArrayList<Integer>[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // initialize graph
//        graph = new int[n+1][n+1];
        graph = new ArrayList[n+1];
        for(int i=1 ; i<=n ;i++) graph[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

//            graph[u][v] = 1;
            graph[u].add(v);
        }

        // initialize visited
        visited = new int[n+1];
        for(int i=1 ; i<=n ; i++) visited[i] = -1;

        // function call
        BFS(x);

        // output
        boolean flag = false;
        for(int i=1 ; i<=n ; i++) {
            if(visited[i] == k){
                flag = true;
                sb.append(i + "\n");
            }
        }

        if(flag) System.out.println(sb);
        else System.out.println(-1);
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int p = queue.poll();

//            for(int i=1 ; i<=n ; i++) {
            for(int i : graph[p]) {
//                System.out.println("now_node : " + p);

//                if(visited[i] == -1 && graph[p][i] == 1) {
                if(visited[i] == -1) {
                    visited[i] = visited[p] + 1;
                    queue.offer(i);
                }

//                System.out.println("visited[" +i +"] : " + visited[i]);
//                System.out.println("queue : " + queue);
//                System.out.println("-------------------------------");
            }
        }
    }
}
