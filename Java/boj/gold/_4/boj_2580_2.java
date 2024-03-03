package boj.gold._4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class boj_2580_2 {
    // 스도쿠
    static int[][] map, result;
    static List<Point> emptyList;

    public static void main(String[] args) throws IOException {
        init();
        sudoku(0);
        print();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        result = new int[9][9];
        emptyList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) emptyList.add(new Point(i, j));
            }
        }
    }

    public static void sudoku(int idx) {
        // basis part
        if (idx == emptyList.size()) {
            copy();
            return ;
        }

        // inductive part
        Point point = emptyList.get(idx);
        boolean[] isNum = new boolean[10];

        // 가로 세로
        for(int i=0 ; i<9 ; i++) {
            isNum[map[point.x][i]] = true;
            isNum[map[i][point.y]] = true;
        }

        // 대각선
        int mx = (point.x / 3) * 3 + 1;
        int my = (point.y / 3) * 3 + 1;

        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        for (int i = 0; i < 9; i++) {
            int nx = mx + dx[i];
            int ny = my + dy[i];
            isNum[map[nx][ny]] = true;
        }

        // 값 넣기
        for (int i = 1; i <= 9; i++) {
            if(!isNum[i]) {
                map[point.x][point.y] = i;
                sudoku(idx+1);
                map[point.x][point.y] = 0;
            }
        }
    }

    public static void copy() {
        for (int i = 0; i < 9; i++)
            result[i] = map[i].clone();
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

