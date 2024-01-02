package ssafy.algo_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2 {
    // 스도쿠 검증 (D2)
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            // arr input
            arr = new int[9][9];
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // function call
            sb.append("#" + (i+1) + " " + sudoku() + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static int sudoku() {
        for (int i = 0; i < 9; i++) {
            if (!width(i) || !height(i) || !square(i/3, (i%3)*3))
                return 0;
        }

        return 1;
    }

    public static boolean square(int x, int y) {
        boolean[] number = new boolean[10];

        for (int i = x; i < 3; i++) {
            for (int j = y; j < 3; j++) {
                int num = arr[i][j];
                if(!number[num]) number[num] = true;
                else return false;
            }
        }

        return true;
    }

    public static boolean width(int x) {
        boolean[] number = new boolean[10];

        for (int i = 0; i < 9; i++) {
            int num = arr[x][i];
            if(!number[num]) number[num] = true;
            else return false;
        }
        return true;
    }

    public static boolean height(int y) {
        boolean[] number = new boolean[10];

        for (int i = 0; i < 9; i++) {
            int num = arr[i][y];
            if(!number[num]) number[num] = true;
            else return false;
        }
        return true;
    }
}
