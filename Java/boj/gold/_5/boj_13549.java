package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13549 {
    // 숨바꼭질 3
    private static int n, k, min = Integer.MAX_VALUE;
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(min);

    }

    public static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x] = true;
            if(node.x == k) min = Math.min(min, node.time);

            int[] arr = {node.x * 2, node.x + 1, node.x -1};
            for(int i=0 ; i<3 ; i++) {
                int new_node = arr[i];

                if(rangeCheck(new_node) && !visited[new_node]) {
                    if(i == 0) queue.offer(new Node(new_node, node.time));
                    else queue.offer(new Node(new_node, node.time + 1));
                }
            }
        }
    }

    public static boolean rangeCheck(int num) {
        return num >= 0 && num <= 100000;
    }

    public static class Node {
        int x, time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
