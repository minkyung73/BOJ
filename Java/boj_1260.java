import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static int n, m, v;
    static int[][] Dgraph = new int[1001][1001];
    static int[][] Bgraph = new int[1001][1001];
    static boolean[] Dvisit = new boolean[10001];

    static void DFS(int node) {
        Dvisit[node] = true;
        System.out.print(node + " ");

        for(int i=1 ; i<=n ; i++) {
            if(!Dvisit[i] && Dgraph[node][i] == 1)
                DFS(i);
        }
    }

    static void BFS(int node) {
        boolean[] Bvisit = new boolean[10001];
        Queue<Integer> queue = new LinkedList<Integer>();
        Bvisit[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            System.out.print(p + " ");

            for(int i=1 ; i<=n ; i++) {
                if(!Bvisit[i] && Bgraph[p][i] == 1) {
                    Bvisit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // DFS와 BFS

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Dgraph[u][v] = Dgraph[v][u] = 1;
            Bgraph[u][v] = Bgraph[v][u] = 1;
        }

        DFS(v);
        System.out.println();
        BFS(v);
    }
}
