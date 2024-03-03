package boj.gold._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136 {
    // 색종이 붙이기
    static int[][] map;
    static int result;
    static int[] inventory = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        init();
        overwrite(0, 0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void overwrite(int x, int y, int cnt) {
        // basis part
        if(x == 10) {
            result = Math.min(result, cnt);
            return ;
        }

        // inductive part
        if(map[x][y] == 0) {
            if(y == 9) overwrite(x+1, 0, cnt);
            else overwrite(x, y + 1, cnt);
        } else if(map[x][y] == 1) {
            for (int i = 5; i >= 1 ; i--) {
                if(checkSize(x, y, i) && inventory[i] > 0) {
                    attach(x, y, i);
//                    System.out.println(i + " after attach(" + x + " " + y + ")");
//                    print();

                    if(y + i > 9) overwrite(x + 1, 0, cnt + 1);
                    else overwrite(x, y + i, cnt + 1);

                    detach(x, y, i);
//                    System.out.println(i + " after detach(" + x + " " + y + ")");
//                    print();
                }
            }
        }
    }

    public static boolean checkSize(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y+size; j++) {
                if(!checkRange(i, j) || map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < 10  && y >= 0 && y < 10;
    }

    public static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++)
                map[i][j] = 0;
        }
        inventory[size]--;
    }

    public static void detach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++)
                map[i][j] = 1;
        }
        inventory[size]++;
    }

    public static void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");
    }
}
