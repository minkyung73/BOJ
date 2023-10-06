import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2644 {
    // 촌수 계산
    private static int n, a, b, cnt, res=-1;
    private static int[][] Dgraph = new int[101][101];
    private static boolean[] Dvisit = new boolean[101];

    public static void DFS(int start, int end, int cnt) {
        if(start == end) {
            res = cnt;
            return;
        }

        Dvisit[start] = true;

        for(int i=1 ; i<=n ; i++) {
            if(!Dvisit[i] && Dgraph[start][i] == 1)
                DFS(i, end, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Dgraph[u][v] = Dgraph[v][u] = 1;
        }

        DFS(a, b, 0);
        System.out.println(res);
    }
}
