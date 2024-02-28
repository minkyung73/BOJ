package swea.etc;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class 산악구조로봇adjList {
	// 산악구조로봇
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	static Node[][] adjList;
	static int[][] minDistance;
	static boolean[][] visited;
	
	static final int INF = Integer.MAX_VALUE;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			init();
			dijkstra();
			sb.append("#").append(i).append(" ");
			sb.append(minDistance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		adjList = new Node[N][N];
		minDistance = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		makeAdjList();
		
		for(int i=0 ; i<N ; i++) Arrays.fill(minDistance[i], INF);
		minDistance[0][0] = 0;
	}
	
	public static void makeAdjList() {
		// map[i][j]에서 map[x][y]로 갈 때 weight
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ;j<N ; j++) {
				
				for(int k=0 ; k<4 ; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					
					if(checkRange(x, y)) {
						if(map[i][j] == map[x][y])
							adjList[i][j] = new Node(x, y, k, 1, adjList[i][j]);
						else if(map[i][j] > map[x][y])
							adjList[i][j] = new Node(x, y, k, 0, adjList[i][j]);
						else 
							adjList[i][j] = new Node(x, y, k, 2 * (map[x][y] - map[i][j]), adjList[i][j]);
					}
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void dijkstra() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				int min = INF;
				Point stopOver = null;
				
				for(int k=0 ; k<N ; k++) {
					for(int l=0 ; l<N ; l++) {
						if(!visited[k][l] && min > minDistance[k][l]) {
							min = minDistance[k][l];
							stopOver = new Point(k, l);
						}						
					} // end of for l loop
				} // end of for k loop
				
				if(stopOver == null) break;
				visited[stopOver.x][stopOver.y] = true;
				
				for(Node temp = adjList[stopOver.x][stopOver.y] ; temp != null ; temp = temp.next) {
					if(minDistance[temp.nx][temp.ny] > min + temp.w)
						minDistance[temp.nx][temp.ny] = min + temp.w;
				} // end of for temp loop
			} // end of for j loop
		} // end of for i loop
	}
	
	public static class Node {
		int nx, ny, dir, w;
		Node next;
		
		public Node(int nx, int ny, int dir, int w, Node next) {
			this.nx = nx;
			this.ny = ny;
			this.dir = dir;
			this.w = w;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [nx=" + nx + ", ny=" + ny + ", dir=" + dir + ", w=" + w + ", next=" + next + "]";
		}

	}
}
