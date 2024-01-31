package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1493 {
    // 수의 새로운 연산
    static int[][] map = new int[301][301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        init(); // function call

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // #((&p) + (&q))
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // #((x,y) + (z,w))
            int[] xy = find(p);
            int[] zw = find(q);

            // #(x+z, y+w)
            int xz = xy[0] + zw[0];
            int yw = xy[1] + zw[1];

            // result
            sb.append("#" + (i+1) + " " + map[xz][yw] + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static void init() {
        int temp_i = 0, temp_j = 0;

        for (int i = 1; i <= 300; i++) {
            if(i==1 || i==2) temp_i = 1;
            else temp_i++;

            temp_j = i;

            for (int j = 1; j <= 300; j++) {
                map[i][j] = j == 1 ? map[i-1][j] + temp_i : map[i][j-1] + temp_j;
                temp_j++;
            }
        }
    }

    public static int[] find(int num) {
        int[] ans = new int[2];

        L: for (int i = 1; i <= 300; i++) {
            for (int j = 1; j <= 300; j++) {
                if(map[i][j] == num) {
                    ans = new int[]{i, j};
                    break L;
                }

                if(map[i][j] > num)
                    break;
            }
        }

        return ans;
    }
}
