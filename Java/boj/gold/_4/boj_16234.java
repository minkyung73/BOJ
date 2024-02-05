package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234 {
	// 인구이동
	static int n, l, r;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	static int day;
	static List<List<Node>> list;
	static List<Integer> average;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n, l, r input
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		// initialize
		map = new int[n][n];
		day = 0;

		// map input
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 인구 이동
		while(true) {
			// initialize
			visited = new boolean[n][n];
			list = new ArrayList<>();
			average = new ArrayList<>();
			
			// BFS
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(!visited[i][j] && checkPopulation(new Node(i, j))) {
						list.add(new ArrayList<>());
						BFS(i, j);
					}
				}
			}
			
			// list 의 사이즈가 0이면 더이상 업데이트 할 게 없으므로 break
			// 아니라면 업데이트 해야하므로 day++
			if(list.size() == 0) break;
			else day++;
			
			// 값을 업데이트
			for(int i=0 ; i<list.size() ; i++) {
				int avg = average.get(i);
				
				for(int j=0 ; j<list.get(i).size() ; j++) {
					int nx = list.get(i).get(j).x;
					int ny = list.get(i).get(j).y;
					
					map[nx][ny] = avg;
				}
			}
			
		} // end of while
		
		// output
		System.out.println(day);
	}
	
	public static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		int sum = 0;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();	
			
			sum += map[now.x][now.y];
			cnt++;
			list.get(list.size()-1).add(new Node(now.x, now.y));
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) 
						&& checkDiff(now, new Node(nx, ny)) 
						&& !visited[nx][ny]) {
					
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		average.add(sum/cnt);
	}
	
	public static boolean checkDiff(Node cur, Node next) {
		int m1 = map[cur.x][cur.y];
		int m2 = map[next.x][next.y];
		
		int diff = Math.abs(m1-m2);
		return diff >= l && diff <= r;
	}
	
	public static boolean checkPopulation(Node cur) {
		int m1 = map[cur.x][cur.y];
		int m2;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];
			
			if(!checkRange(nx, ny)) continue;
			
			m2 = map[nx][ny];
			
			int difference = Math.abs(m1 - m2);
			if(difference >= l && difference <= r) return true;
		}
		
		return false;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
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
