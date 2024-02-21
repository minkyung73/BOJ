package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7465_BFS {
    // 창용 마을 무리의 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int n, m;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
        	init();
        	int res = solution();
            sb.append("#").append(i).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }
    
    public static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][v] = map[v][u] = 1;
        }
    }

    public static int solution() {
    	int cnt = 0;
    	
    	for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                BFS(i);
                cnt++;
            }
        }
    	
    	return cnt;
    }
    
    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
        	int now = queue.poll();
        	
        	for(int i=1 ; i<=n ; i++) {
        		if(!visited[i] && map[now][i] == 1) {
        			queue.offer(i);
        			visited[i] = true;
        		}
        	}
        }
    }
}
