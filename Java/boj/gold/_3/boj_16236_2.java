package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16236_2 {
    // 아기 상어
    static int n, sec;
    static int[][] map;
    static List<Fish> fishList;
    static Fish shark;

    public static void main(String[] args) throws IOException {
        init();
        babyShark();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        fishList = new ArrayList<>();
        sec = 0;

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) shark = new Fish(i, j, 2);
                else if(map[i][j] != 0) fishList.add(new Fish(i, j, map[i][j]));
            }
        }
    }

    public static void babyShark() {
        TreeSet<Fish> fishTreeSet = new TreeSet<>(new CustomComparator());

        while(!fishList.isEmpty()) {
            for(int i=0 ; i<shark.size ; i++) {
                // 현재 상어 사이즈에서 먹을 수 있는 물고기 리스트
                for (Fish fish : fishList) {
                    if(fishTreeSet.contains(fish)) continue;
                    if(fish.size < shark.size) fishTreeSet.add(fish);
                }

                // 이동
                Fish removed = fishTreeSet.first();
                move(removed);

                // 걸리는 시간
                sec += BFS(removed);

                // 삭제
                fishList.remove(removed);
                fishTreeSet.remove(removed);
            }
            shark.setSize(shark.size+1);
        }
    }

    public static void move(Fish removed) {
        map[shark.x][shark.y] = 0;
        shark.setX(removed.x);
        shark.setY(removed.y);
        map[shark.x][shark.y] = 9;
    }

    public static int BFS(Fish fish) {
        Queue<Fish> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 시작점 - 상어
        queue.offer(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        // size를 cnt로 쓰자.....!! ㅜㅜ
        while(!queue.isEmpty()) {
            Fish now = queue.poll();

            if(now.x == fish.x && now.y == fish.y) return now.size;

            for(int i=0 ; i<4 ; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark.size) {
                    queue.offer(new Fish(nx, ny, now.size+1));
                    visited[nx][ny] = true;
                }
            }
        }

        return 0;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static class Fish {
        int x, y, size;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static class CustomComparator implements Comparator<Fish> {
        @Override
        public int compare(Fish o1, Fish o2) {
            int d1 = BFS(o1);
            int d2 = BFS(o2);

            if (d1 != d2) return d1 - d2;

            return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
        }
    }
}
