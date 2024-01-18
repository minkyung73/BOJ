package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1107 {
    static int n, m;
    static long cnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // initialize
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine());
        if (m > 0) {
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                visited[num] = true;
            }
        }

        // 1 - 현재 채널과 일치한 경우
        if (n == 100) {
            System.out.println(0);
            return ;
        }

        // 2 - 고장나지 않은 숫자만으로도 가능한 경우
        cnt = Math.abs(n - 100);

        // 3 - DFS
        DFS(0, 0);

        // output
        System.out.println(cnt);
    }

    public static void DFS(int idx, int click) {
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                int newButton = click * 10 + i;
                int count = Math.abs(n - newButton) + String.valueOf(newButton).length();
                cnt = Math.min(cnt, count);

                if(idx < 6) DFS(idx + 1, newButton);
            }
        }
    }
}
