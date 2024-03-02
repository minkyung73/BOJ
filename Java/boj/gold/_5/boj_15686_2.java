package boj.gold._5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class boj_15686_2 {
    // 치킨 배달
    static int N, M;
    static int[][] map;
    static List<Node> chickenList, houseList;
    static Node[] selectedChicken;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0);
        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();
        selectedChicken = new Node[M];
        visited = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) houseList.add(new Node(i, j));
                else if(map[i][j] == 2) chickenList.add(new Node(i, j));
            }
        }
    }

    public static void combination(int idx, int k) {
        // basis part
        if(k == M) {
            getDistance();
            return ;
        }

        if(idx == chickenList.size()) return ;

        // inductive part
        selectedChicken[k] = chickenList.get(idx);
        combination(idx + 1, k + 1);
        combination(idx + 1, k);
    }

    public static void getDistance() {
        int sum = 0;

        for (Node house : houseList) {
            int min = Integer.MAX_VALUE;
            for (Node chicken : selectedChicken) {
                min = Math.min(min, manhattan(house, chicken));
            }
            sum += min;
        }

        result = Math.min(result, sum);
    }

    public static int manhattan(Node house, Node chicken) {
        return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
