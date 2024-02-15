package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206 {
	// 벽 부수고 이동하기
	static int n, m;
	static int[][] map;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	static int result;
	
	public static void main(String[] args) throws IOException {
		init();
		BFS();
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		result = Integer.MAX_VALUE;
	
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ;j <m ; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
	}
	
	public static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		// 3차원 - 부수고 온 애인지 아닌지
		boolean[][][] visited = new boolean[n][m][2];
		
		queue.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.x == n-1 && now.y == m-1) {
				result = Math.min(result, now.cnt);
				return ;
			}
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx == n-1 && ny == m-1) {
					result = Math.min(result, now.cnt+1);
					return ;
				}
				
				if(checkRange(nx, ny)) {

					// 길인 경우 - 그냥 가~
					if(map[nx][ny] == 0 && !visited[nx][ny][now.flag]) {
						visited[nx][ny][now.flag] = true;											
						queue.offer(new Node(nx, ny, now.cnt+1, now.flag));
					}
					
					// 벽인 경우 - 부술 수 있고, 이미 부순 경우 못 가
					// 부수지 않았다면 부셔
					else if(map[nx][ny] == 1 && now.flag == 0) {
						visited[nx][ny][1] = true;
						queue.offer(new Node(nx, ny, now.cnt+1, 1));
					}
					
					
				}
			}
		}
	} 
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static class Node {
		int x, y, cnt, flag;

		public Node(int x, int y, int cnt, int flag) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.flag = flag;
		}
	}




}
