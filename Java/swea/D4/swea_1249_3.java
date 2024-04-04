package swea.D4;

import java.io.*;
import java.util.*;

public class swea_1249_3 {
	// [S/W 문제해결 응용] 4일차 - 보급로
	// BFS - Point 사용하지 않고 배열 사용하기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ;i <=T ; i++) {
			init();
			sb.append("#").append(i).append(" ").append(BFS()).append("\n");
		}
		System.out.println(sb);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0 ;i<N ; i++) {
			String str = br.readLine();
			for(int j=0 ;j<N ; j++ ) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
	}
	
	public static int BFS() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new int[] {0, 0, 0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == N-1 && now[1] == N-1)
				return now[2];
			
			for(int i=0 ;i<4 ; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny]) {
					queue.offer(new int[] {nx, ny, now[2] + map[nx][ny]});
					visited[nx][ny] = true;
				}
			}
		}
		
		return -1;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
