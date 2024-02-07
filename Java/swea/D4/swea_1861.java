package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1861 {
	// 정사각형 방
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] res = new int[2];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			res[0] = 0;	// 방번호
			res[1] = Integer.MIN_VALUE;	// 최대 몇 개의 방을 이동할 수 있는지
			
			// map input
			for(int j=0 ; j<n ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0 ; k<n ; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<n ; k++) {
					visited = new boolean[n][n];
					// function call: BFS
					BFS(j, k);
					
					// function call: DFS
//					cnt = 0;
//					DFS(j, k, 0);
				}
			}
			
			
			// result
			sb.append("#").append(i).append(" ")
				.append(res[0]).append(" ").append(res[1]).append("\n");
		}
		
		// output
		System.out.println(sb);
	}

	public static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			cnt++;
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) 
						&& map[now.x][now.y] + 1 == map[nx][ny]
						&& !visited[nx][ny]) {
					
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		// update result
		updateResultForBFS(cnt, map[x][y]);
	}
	
	public static void DFS(int x, int y, int depth) {
		visited[x][y] = true;
		cnt++;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) 
					&& !visited[nx][ny] 
					&& map[x][y] + 1 == map[nx][ny]) {
				
				DFS(nx, ny, depth+1);
			}
		}

		if(depth == 0) updateResultForDFS(map[x][y]);
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	public static void updateResultForDFS(int m) {
		if(cnt > res[1]) {
			res[0] = m;
			res[1] = cnt;
		}
		else if(cnt == res[1]) {
			res[0] = Math.min(res[0], m);
		}
	}
	
	public static void updateResultForBFS(int cnt, int m) {
		if(cnt > res[1]) {
			res[0] = m;
			res[1] = cnt;
		}
		else if(cnt == res[1]) {
			res[0] = Math.min(res[0], m);
		}
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
