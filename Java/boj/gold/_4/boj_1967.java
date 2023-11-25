package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1967 {
    // 트리의 지름
    private static ArrayList<Node> list[];
    private static boolean visited[];
    private static int dist=0, farthestNode=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        // compute weightSum & farthestNode
        visited = new boolean[n+1];
        visited[1] = true;
        DFS(1, 0);

        // compute result
        visited = new boolean[n+1];
        visited[farthestNode] = true;
        dist = 0;
        DFS(farthestNode, 0);

        // output
        System.out.println(dist);
    }

    public static void DFS(int num, int weightSum) {
        if(dist < weightSum) {
            farthestNode = num;
            dist = weightSum;
        }

        for (Node v : list[num]) {
            if(!visited[v.num]) {
                visited[v.num] = true;
                DFS(v.num, weightSum + v.weight);
            }
        }
    }

    public static class Node {
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
