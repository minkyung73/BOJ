package swea.D2;

import java.io.IOException;
import java.util.Scanner;

public class swea_1954 {
    // 달팽이 숫자
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            sb.append("#" + (i+1) + "\n");
            n = sc.nextInt();
            arr = new int[n][n];
            snail();

            for(int j=0 ; j<n ; j++) {
                for(int k=0 ; k<n ; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void snail() {
        int num = 1;
        int x = 0, y = 0;
        int xAxis = 0, yAxis = 1;

        for(int i=0 ; i<n * n ; i++) {
            arr[x][y] = num;
            num++;

            // rotate
            if(xAxis == 0 && yAxis == 1) {
                if(y+1 < n && arr[x][y+1] == 0) y++;
                else {
                    x++;
                    xAxis = 1;
                    yAxis = 0;
                }
            }
            else if(xAxis == 1 && yAxis == 0) {
                if(x+1 < n && arr[x+1][y] == 0) x++;
                else {
                    y--;
                    xAxis = 0;
                    yAxis = -1;
                }
            }
            else if(xAxis == 0 && yAxis == -1) {
                if(y-1 >= 0 && arr[x][y-1] == 0) y--;
                else {
                    x--;
                    xAxis = -1;
                    yAxis = 0;
                }
            }
            else if(xAxis == -1 && yAxis == 0) {
                if(x-1 >= 0 && arr[x-1][y] == 0) x--;
                else {
                    y++;
                    xAxis = 0;
                    yAxis = 1;
                }
            }
        }
    }
}
