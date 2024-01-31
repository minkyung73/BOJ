package hdst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hdst_6282 {
	static int n, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Integer> list;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// initialize
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		cnt = 0;
		list = new ArrayList<>();
		
		// map input
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ;j<n ;j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		
		// function call - BFS
		for(int i=0 ;i <n ; i++) {
			for(int j=0 ;j <n ; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt++;
					list.add(BFS(i, j));
				}
			}
		}
		Collections.sort(list);
		
		// output
		System.out.println(cnt);
		for (Integer l : list) System.out.println(l);
	}

	public static int BFS(int x, int y) {
		Queue<Node> queue = new LinkedList();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		int num = 1;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
					num++;
				}
			}
		}
		
		return num;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
