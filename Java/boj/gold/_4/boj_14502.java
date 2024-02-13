package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502 {
	// 연구소 
	
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        DFS(0);
        System.out.println(answer);
    }
    
    public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // initialize
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // map input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void DFS(int depth) {
        // basis part
    	if(depth == 3) {
            BFS();
            return ;
        }

        // inductive part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        int[][] virus_map = new int[n][m];
        Queue<Node> queue = new LinkedList<>();

        // copy
        for (int i = 0; i < n; i++)
        	virus_map[i] = map[i].clone();

        // 초기 바이러스의 위치 offer
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virus_map[i][j] == 2)
                    queue.offer(new Node(i, j));
            }
        }

        // 바이러스 전파
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (checkRange(nx, ny) && virus_map[nx][ny] == 0) {
                    virus_map[nx][ny] = 2;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        // 안전영역 크기 구하기
        count(virus_map);
    }

    public static void count(int[][] virus_map) {
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virus_map[i][j] == 0)
                    temp++;
            }
        }

        answer = Math.max(answer, temp);
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 & y < m;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
