package swea.etc;

import java.util.*;
import java.io.*;

public class 산악구조로봇PQ {
	static int N;
	static boolean[][] v;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			// input
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			
			for(int j=0 ; j<N ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0 ; k<N ; k++)
					map[j][k] = Integer.parseInt(st.nextToken());
			}
			
			// function call
//			System.out.println(dijkstra());
			System.out.println(dijkstraPQ());
		}
	}
	
	public static int dijkstraPQ() {
		Queue<int[]> Q = new PriorityQueue<>((o1, o2) -> {return o1[2] - o2[2];});
		
		Q.add(new int[] {0, 0, 0});
		int[][] dist = new int[N][N];
		
		for(int i=0 ; i<dist.length ; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		
		while(!Q.isEmpty()) {
			int[] p = Q.poll();
			
			// 먼저 오면 끝이라 여기서 break 걸어줘 ~~
			if(p[0] == N-1 && p[1] == N-1)
				return p[2];
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = p[0] + dr[d];
				int nc = p[1] + dc[d];
				
				if(!check(nr, nc)) continue;
				
				int value = 0;
				if(map[p[0]][p[1]] > map[nr][nc]) {
					value = 0;
				} else if(map[p[0]][p[1]] < map[nr][nc]) {
					value = (map[nr][nc] - map[p[0]][p[1]])*2;
				} else value = 1;
				
				if(dist[nr][nc] > p[2] + value) {
					dist[nr][nc] = p[2] + value;
					Q.offer(new int[] {nr, nc, p[2] + value});
				}
			}
		}
		
		return -1;
	}
	
	public static int dijkstra() {
		Queue<int[]> Q = new ArrayDeque<>();
		v[0][0] = true;
		Q.add(new int[] {0, 0});
		int[][] dist = new int[N][N];
		
		for(int i=0 ; i<dist.length ; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		
		while(!Q.isEmpty()) {
			int[] p = Q.poll();
			for(int d = 0 ; d<4 ; d++) {
				int nr = p[0] + dr[d];
				int nc = p[1] + dc[d];
				
				if(!check(nr, nc)) continue;
				
				int value = 0;
				if(map[p[0]][p[1]] > map[nr][nc]) {
					value = 0;
				} else if(map[p[0]][p[1]] < map[nr][nc]) {
					value = (map[nr][nc] - map[p[0]][p[1]])*2;
				} else value = 1;
				
				if(dist[nr][nc] > dist[p[0]][p[1]] + value) {
					dist[nr][nc] = dist[p[0]][p[1]] + value;
					Q.offer(new int[] {nr, nc});
					v[nr][nc] = true;
				}
				
			}
		}
		
		return dist[N-1][N-1];
	}
	
	public static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
