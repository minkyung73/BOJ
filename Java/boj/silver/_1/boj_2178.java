package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
    // 미로 탐색

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        
        BFS(0, 0);
        System.out.println(map[n-1][m-1]);
        
//        DFS(0, 0, 1);
//        System.out.println(result);
    }
    
    public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            for(int j=0 ;j <m ; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
    }

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new Node(nx, ny));
                    map[nx][ny] = map[now.x][now.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void DFS(int x, int y, int cnt) {
    	// basis part
    	if(x == n-1 && y == m-1) {
    		result = Math.min(result, cnt);
    		return ;
    	}
    	
    	// inductive part
    	for(int i=0 ; i<4 ; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
    			visited[nx][ny] = true;
    			DFS(nx, ny, cnt+1);
    		}
    	}
    }
    
    
    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    public static class Node {
    	int x;
    	int y;
    	
    	public Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
