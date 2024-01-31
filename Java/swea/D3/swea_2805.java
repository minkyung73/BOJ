package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea_2805 {
	static int N, sum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			// initialize
			N = Integer.parseInt(br.readLine());
			sum = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			
			// map input
			for(int j=0 ;j<N ; j++) {
				String str = br.readLine();
				for(int k=0 ; k<N ; k++) {
					map[j][k] = Integer.parseInt(String.valueOf(str.charAt(k)));
				}
			}
			
			// function call
			BFS(N/2, N/2);
			
			// result
			sb.append("#" + (i+1) + " " + sum + "\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	public static void BFS(int x, int y) {
		if(x == 0 && y == 0) {
			sum = map[x][y];
			return ;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				// 추가 조건 - 맨해튼 거리가 N/2 이하여야 함!
				if(checkRange(nx, ny) && !visited[nx][ny] 
						&& calcManhattan(x, y, nx, ny) <= N/2) {
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
					sum += map[nx][ny];
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static int calcManhattan(int x1, int y1, int x2, int y2) {
		return Math.abs(y2-y1) + Math.abs(x2-x1);
	}
	
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
