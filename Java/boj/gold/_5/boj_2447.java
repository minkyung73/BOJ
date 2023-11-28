package boj.gold._5;

import java.io.IOException;
import java.util.Scanner;

public class boj_2447 {
    // 별 찍기 - 10
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        arr = new int[n][n];

        star(n, 0, 0, false);  // function call

        // StringBuilder
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(arr[i][j] == 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        // output
        System.out.println(sb);
    }

    public static void star(int n, int x, int y, boolean blank) {

        if(blank) {
            for(int i=x ; i<x+n ; i++) {
                for(int j=y ; j<y+n ; j++)
                        arr[i][j] = 0;
            }
            return ;
        }

        if(n==1) {
            arr[x][y] = 1;
            return ;
        }

        int size = n/3;
        int cnt = 0;
        for(int i=x ; i<x+n ; i+= size) {
            for(int j=y ; j<y+n ; j+= size) {
                cnt++;
                star(size, i, j, cnt == 5);
            }
        }
    }
}
