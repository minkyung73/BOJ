package codeup.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class code_3120 {
    // 리모컨
    private static int a, b, cnt = 0;
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean visited[] = new boolean[41];
    private static int control[] = {-1, 1, -5, 5, -10, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        BFS(a);
        System.out.println(cnt);
    }

    public static void BFS(int temp) {
        q.add(temp);
        visited[temp] = true;

        while (!q.isEmpty()) {
            int cur;
            int size = q.size();

            for(int i=0 ; i<size ; i++) {
                cur = q.poll();
                if(cur == b) return ;

                for(int j=0 ; j<6 ; j++) {
                    int next = cur + control[j];
                    if((next >= 0 && next <= 40) && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            cnt++;
        }
    }
}
