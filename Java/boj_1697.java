import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    // 숨바꼭질

    private static int N, K, cnt = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[400001];

        if(N!=K) System.out.println(BFS());
        else System.out.println(0);
    }

    public static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur_num;

            for(int i=0 ; i<size ; i++) {
//                System.out.println(queue);
                cur_num = queue.poll();
//                System.out.println(cur_num);
//                System.out.println();

                if(cur_num == K) return cnt;

                int num1 = cur_num - 1;
                int num2 = cur_num + 1;
                int num3 = cur_num * 2;

                // 현재 값이 0인 경우
                if(cur_num == 0 && !visited[num2]) {
                    queue.add(num2);
                    visited[num2] = true;
                    continue;
                }

                if(!visited[num1] && num1 != 0) {
                    visited[num1] = true;
                    queue.add(num1);
                }

                if(!visited[num2] && cur_num < K && num2 != 0) {
                    visited[num2] = true;
                    queue.add(num2);
                }

                if(!visited[num3] && cur_num < K && num3 != 0) {
                    visited[num3] = true;
                    queue.add(num3);
                }
            }
            cnt++;
//            System.out.println("cnt: " + cnt);
        }

        return cnt;
    }
}
