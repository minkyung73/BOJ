package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_17135 {
	// 캐슬 디펜스
	
	static int n, m, d;
	static int[][] map, copy;
	static int[] archers;
	static int result;
	
	public static void main(String[] args) throws IOException {
		init();
		combi(0, 0);
		System.out.println(result);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		copy = new int[n][m];
		archers = new int[3];
		result = Integer.MIN_VALUE;
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void combi(int idx, int k) {
		// basis part
		if(k == 3) {
//			System.out.println("==============================");
//			System.out.println(Arrays.toString(archers));
			copyMap();
			result = Math.max(result, war());
			return ;
		}
		
		// inductive part
		for(int i=idx ; i<m ; i++) {
			archers[k] = i;
			combi(i+1, k+1);
			archers[k] = 0;
		}
	}

	private static int war() {
		int cnt = 0;
		
		for(int i=n-1 ; i>=0 ; i--) {
//			print();
			cnt += attack();	// 공격
			updateMap();	// 공격이 끝난 후 
		}
//		System.out.println("total cnt: " + cnt);
		return cnt;
	}
	
	public static void print() {
		for(int i=0 ; i<n ; i++) {
			for(int j=0  ;j <m ;j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int attack() {
		int cnt = 0;
		HashSet<Enemy> enemies = new HashSet<>();
		
		// i번 궁수가 공격할 수 있는 리스트
		for(int i=0 ; i<3 ; i++) {
//			System.out.println("궁수: " + archers[i]);
			Enemy enemy = getEnemy(n, archers[i]);
			
			if(enemy != null) {
//				System.out.println("공격당한 적의 위치: " + enemy.x + " " + enemy.y);
				copy[enemy.x][enemy.y]++;
				if(!enemies.contains(enemy)) {
					enemies.add(enemy);
					cnt++;
				}
//				cnt++;
			}
		}
		
		
//		System.out.println("cnt: " + cnt+"\n");
		return cnt;
//		return enemies.size();
	}

	/*
	 *  궁수는 원래 (n, archerY)에 위치하지만
	 *  (n-1, archerY)에 위치한다고 하고, 거리가 d-1 이하인 곳에 위치한 적을 구한다.
	 */
	public static Enemy getEnemy(int archerX, int archerY) {
		// 좌, 상, 우
		int[] dx = {0, -1, 0};
		int[] dy = {-1, 0, 1};
		
		Queue<Enemy> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		queue.offer(new Enemy(archerX - 1, archerY, 1));
		visited[archerX-1][archerY] = true;
		
		while(!queue.isEmpty()) {
			Enemy now = queue.poll();
			
			if(now.dist > d) break;
			
			if(copy[now.x][now.y] >= 1) 
				return new Enemy(now.x, now.y, now.dist);

			for(int i=0 ; i<3 ; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny]) {
					queue.offer(new Enemy(nx, ny, now.dist+1));
					visited[nx][ny] = true;
				}
			}
		}
		
		return null;
	}

	private static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	// 원래 맵 복사 (궁수 3명의 위치를 정했을 때 마다)
	public static void copyMap() {
		copy = new int[n][m];
		for(int i=0 ; i<n ; i++) {
			copy[i] = map[i].clone();
		}
	}

	// 적들이 앞으로 한 칸 전진
	public static void updateMap() {
		for(int i=n-1 ; i>0 ; i--) copy[i] = copy[i-1].clone();
		copy[0] = new int[m];
	}

	public static class Enemy {
		int x, y, dist;

		public Enemy(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}


		@Override
		public String toString() {
			return "Enemy [x=" + x + ", y=" + y + "]";
		}


		@Override
		public boolean equals(Object obj) {
			Enemy other = (Enemy) obj;
			return x == other.x && y == other.y;
		}
	}
}
