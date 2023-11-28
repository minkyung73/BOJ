package boj.gold._4;

import java.io.IOException;
import java.util.Scanner;

public class boj_2448 {
    // 별 찍기 - 11
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        arr = new int[n][n*2-1];

        star(n, 0, n-1);

        // StringBuilder
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ;j <n*2-1 ; j++) {
                if(arr[i][j] == 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        // output
        System.out.println(sb);
    }

    public static void star(int n, int x, int y) {

        if(n==3) {
            arr[x][y] = 1;
            arr[x+1][y-1] = arr[x+1][y+1] = 1;
            arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = 1;
            return ;
        }

        int size = n/2;

        star(size, x, y);
        star(size, x + size, y - size);
        star(size, x + size, y + size);

    }
}
