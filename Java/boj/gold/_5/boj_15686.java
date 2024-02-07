package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15686 {
    // 치킨 배달

    static int n, m;
    static int[][] map;
    static List<Node> houseList;
    static List<Node> chickenList;
    static Node[] selectedChicken;
    static boolean[] visitedChicken;
    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        getChickenList(0, 0);

        // output
        System.out.println(answer);
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();
        selectedChicken = new Node[m];
        answer = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) houseList.add(new Node(i, j));
                if(map[i][j] == 2) chickenList.add(new Node(i, j));
            }
        }

        visitedChicken = new boolean[chickenList.size()];
    }

    public static void getChickenList(int idx, int k) {
        // basis part
        if(k == m) {
            findStreet(selectedChicken);
            return ;
        }

        // inductive part
        for(int i=idx ; i<chickenList.size() ; i++ ) {
            if(!visitedChicken[i]) {
                selectedChicken[k] = chickenList.get(i);
                visitedChicken[i] = true;
                getChickenList(i+1, k+1);
                visitedChicken[i] = false;
            }
        }
    }

    public static void findStreet(Node[] selected) {
        int res = 0;

        for (Node house : houseList) {
            int min = Integer.MAX_VALUE;
            for (Node chicken : selected) {
                min = Math.min(min, calcDistance(house, chicken));
            }
            res += min;
        }

        answer = Math.min(answer, res);
    }

    public static int calcDistance(Node house, Node chicken) {
        return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
