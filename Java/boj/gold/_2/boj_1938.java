package boj.gold._2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1938 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // U, D, L, R
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int n;
    static char[][] map;
    static Train train, arrival;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(BFS());
    }

    public static void init() throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        train = new Train(new Point[3], 0, 0);
        arrival = new Train(new Point[3], 0, 0);

        int idx1 = 0, idx2 = 0;

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<n ; j++) {
                char c = str.charAt(j);
                if(c == 'B') train.train[idx1++] = new Point(i, j);
                else if(c == 'E') arrival.train[idx2++] = new Point(i, j);
                map[i][j] = c;
            }
        }

        //  세로
        if(train.train[0].y == train.train[1].y) train.dir = 1;
        if(arrival.train[0].y == arrival.train[1].y) arrival.dir = 1;

        // print
//		System.out.println("출발 기차: " + train);
//		System.out.println("도착 지점: " + arrival);
    }

    public static int BFS() {
        Queue<Train> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][2];	// map의 중심점, 방향

        queue.offer(train);
        visited[train.train[1].x][train.train[1].y][train.dir] = true;

        while(!queue.isEmpty()) {
            Train now = queue.poll();
            int x = now.train[1].x;
            int y = now.train[1].y;
            int d = now.dir;

            // now가 arrival과 같다면 return
            boolean flag = true;
            for(int i=0 ; i<3 ; i++) {
                if((now.train[i].x != arrival.train[i].x) || now.train[i].y != arrival.train[i].y) {
                    flag = false;
                    break;
                }
            }
            if(flag) return now.cnt;

            // move (U, D, L, R)
            for(int i=0 ; i<4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(checkMove(i, now) && !visited[nx][ny][d]) {
//					System.out.println(dir[i] + " " + now);
                    Train nt = move(i, now);
                    queue.offer(nt);
                    visited[nx][ny][d] = true;
                }
            }

            // move T
            if(checkMove(4, now) && !visited[x][y][Math.abs(d-1)]) {
//				System.out.println(dir[4] + " " + now);
                Train nt = move(4, now);
                queue.offer(nt);
                visited[x][y][d] = true;
            }
        }

        return 0;
    }

    public static boolean checkMove(int move_dir, Train now) {
        // 가로일 때,
        if(now.dir == 0) {
            if(move_dir == 0 || move_dir == 1) {	// U, D
                for(int i=0 ; i<3 ; i++) {
                    int nx = now.train[i].x + dx[move_dir];
                    int ny = now.train[i].y + dy[move_dir];

                    if(!checkRange(nx, ny) || map[nx][ny] == '1') {
                        return false;
                    }
                }
            }

            else if(move_dir == 2) {	// L
                int nx = now.train[0].x + dx[move_dir];
                int ny = now.train[0].y + dy[move_dir];

                if(!checkRange(nx, ny) || map[nx][ny] == '1')
                    return false;
            }

            else if(move_dir == 3) {	// R
                int nx = now.train[2].x + dx[move_dir];
                int ny = now.train[2].y + dy[move_dir];

                if(!checkRange(nx, ny) || map[nx][ny] == '1')
                    return false;
            }
        }

        // 세로일 때,
        else if(now.dir == 1) {
            if(move_dir == 0) {		// U
                int nx = now.train[0].x + dx[move_dir];
                int ny = now.train[0].y + dy[move_dir];

                if(!checkRange(nx, ny) || map[nx][ny] == '1')
                    return false;
            }

            else if(move_dir == 1) {	// D
                int nx = now.train[2].x + dx[move_dir];
                int ny = now.train[2].y + dy[move_dir];

                if(!checkRange(nx, ny) || map[nx][ny] == '1')
                    return false;
            }

            else if(move_dir == 2 || move_dir == 3) {	// L, R
                for(int i=0 ; i<3 ; i++) {
                    int nx = now.train[i].x + dx[move_dir];
                    int ny = now.train[i].y + dy[move_dir];

                    if(!checkRange(nx, ny) || map[nx][ny] == '1') {
                        return false;
                    }
                }
            }
        }

        // T
        if(move_dir == 4) {
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            for(int i=0 ; i<8 ; i++) {
                int nx = now.train[1].x + dx[i];
                int ny = now.train[1].y + dy[i];

                if(!checkRange(nx, ny) || map[nx][ny] == '1')
                    return false;
            }
        }

        return true;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static Train move(int move_dir, Train now) {
        Train result = new Train(new Point[3], now.dir, now.cnt+1);

        // U, D, L, R
        if(move_dir != 4) {
            for(int i=0 ; i<3 ; i++) {
                result.train[i] = new Point();
                result.train[i].x = now.train[i].x + dx[move_dir];
                result.train[i].y = now.train[i].y + dy[move_dir];
            }
        }

        // T
        else {
            for(int i=0 ; i<3 ; i++) {
                result.train[i] = new Point();
            }

            if(now.dir == 0) {	// 가로일 때,
                result.train[0].x = now.train[1].x + dx[0];
                result.train[0].y = now.train[1].y + dy[0];

                result.train[1].x = now.train[1].x;
                result.train[1].y = now.train[1].y;

                result.train[2].x = now.train[1].x + dx[1];
                result.train[2].y = now.train[1].y + dy[1];

                result.dir = Math.abs(now.dir - 1);
            }
            else {	// 세로일 때,
                result.train[0].x = now.train[1].x + dx[2];
                result.train[0].y = now.train[1].y + dy[2];

                result.train[1].x = now.train[1].x;
                result.train[1].y = now.train[1].y;

                result.train[2].x = now.train[1].x + dx[3];
                result.train[2].y = now.train[1].y + dy[3];

                result.dir = Math.abs(now.dir - 1);
            }
        }

        return result;
    }

    public static class Train {
        Point[] train;
        int dir;	// 가로: 0, 세로: 1
        int cnt;

        public Train(Point[] train, int dir, int cnt) {
            super();
            this.train = train;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Train [train=" + Arrays.toString(train) + ", dir=" + dir + "]";
        }
    }
}
