package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562 {
    // 나이트의 이동
    private static int T, I, cnt = 0;
    private static int x1, y1, x2, y2;
    private static int nextX, nextY;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dir_X = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dir_Y = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            cnt = 1;

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2) sb.append(0 + "\n");
            else sb.append(BFS() + "\n");
        }

        System.out.println(sb);
    }

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x1, y1});
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] now;
            int nowX, nowY;
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {
                now = queue.poll();
                nowX = now[0];
                nowY = now[1];

                for(int j=0 ; j<8 ; j++) {
                    nextX = nowX + dir_X[j];
                    nextY = nowY + dir_Y[j];

                    if(nextX == x2 && nextY == y2) return cnt;

                    if(rangeCheck() && !visited[nextX][nextY]) {
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }

    public static boolean rangeCheck() {
        return nextX >= 0 && nextX < I
                && nextY >= 0 && nextY < I;
    }
}
