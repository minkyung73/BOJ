package boj.gold._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194 {
	// 달이 차오른다, 가자.
	
	static int n, m;
	static char[][] map;
	static Node minsik;
	static List<Node> key;
	static List<Node> door;
	static List<Character> haveKey;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n and m input
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// initialize
		map = new char[n][m];
		visited = new boolean[n][m][4];
		key = new ArrayList<>();
		door = new ArrayList<>();
		haveKey = new ArrayList<>();

		// map input
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<m ; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == '0') minsik = new Node(i, j, 0);
				
				if(map[i][j] >= 97 && map[i][j] <= 122) key.add(new Node(i, j));
				if(map[i][j] >= 65 && map[i][j] <= 90) door.add(new Node(i, j));
			}
		}
		
		// sort key and door
		sort();	// function call
		
		// function call
		BFS();
		
		// output
		System.out.println(result);
	}
	
	public static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(minsik);
//		visited[minsik.x][minsik.y][0] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			// 1이면 탈출 완료 
			if(map[now.x][now.y] == '1') {
				result = now.move;
				return ;
			}
			
			// 
			for(int i=0 ; i<4 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny][i]) {
					// 벽이면 갈 수 없음
					if(map[nx][ny] == '#') continue;
					
					// 땅
					if(map[nx][ny] == '.') {
						queue.offer(new Node(nx, ny, now.move+1));
						visited[nx][ny][i] = true;
					}
					
					// key 가 있는 곳
					if(map[nx][ny] >= 97 && map[nx][ny] <= 122) {
						// haveKey
						haveKey.add(map[nx][ny]);
						map[nx][ny] = '.';
						queue.offer(new Node(nx, ny, now.move+1));
						visited[nx][ny][i] = true;
					}
					
					// door 가 있는 곳
					if(map[nx][ny] >= 65 && map[nx][ny] <= 90) {
						// 없으면 못 가						
						char k = (char) (map[nx][ny] + 22);
						if(!haveKey.contains(k)) continue;
						
						// key 가 있으면 감
						queue.offer(new Node(nx, ny, now.move+1));
						visited[nx][ny][i] = true;
					}
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public static void sort() {
		// sort key
		Collections.sort(key, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return map[o1.x][o1.y] - map[o2.x][o2.y];
			}
		});
		
		// sort door
		Collections.sort(door, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return map[o1.x][o1.y] - map[o2.x][o2.y];
			}
		});
	}

	public static class Node {
		int x;
		int y;
		int move;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Node(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move= move;
		}
	}
}
