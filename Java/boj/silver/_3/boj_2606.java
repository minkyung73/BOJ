package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2606 {
    // 바이러스
    private static int n, m, cnt = 0;
    private static int[][] Dgraph = new int[101][101];
    private static boolean[] Dvisit = new boolean[101];

    public static void DFS(int node) {

        Dvisit[node] = true;

        for(int i=2 ; i<=n ; i++) {
            if(!Dvisit[i] && Dgraph[node][i] == 1){
                DFS(i);
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Dgraph[x][y] = Dgraph[y][x] = 1;
        }

        DFS(1);
        System.out.println(cnt);
    }
}
