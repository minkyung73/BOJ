package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_16236 {
	// 아기 상어
	static int n;
	static int[][] map;
	static Fish shark;
	static List<Fish> fishAll;
	static int sec;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static TreeSet<Fish> fishList;

	public static void main(String[] args) throws IOException {
		init();
		babyShark();
		System.out.println(sec);
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		sec = 0;
		fishAll = new ArrayList<>();
		visited = new boolean[n][n];
		fishList = new TreeSet<>(new CustomComparator());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					shark = new Fish(i, j, 2);
				if (map[i][j] != 9 && map[i][j] != 0)
					fishAll.add(new Fish(i, j, map[i][j]));
			}
		}
	}

	public static void babyShark() {
		while (!fishAll.isEmpty()) {
//			TreeSet<Fish> fishList = new TreeSet<>(new CustomComparator());
			getFishList();
			int size = fishList.size();
			
			for (int i = 0; i < shark.size; i++) {
				for (Fish fish : fishList) {
					System.out.println(fish + " " + BFS(fish));
				}
				if (fishList.isEmpty()) break;
				
				Fish fish = fishList.first();
				fishList.remove(fish);

				sec += BFS(fish);
				move(fish);
				
				getFishList();
						
				System.out.println("shark size: " + shark.size);
				System.out.println("seconds: " + sec);
				print();
			}
			
			if(size < shark.size) break;
			shark = new Fish(shark.x, shark.y, shark.size + 1);
		}
	}

	public static int BFS(Fish target) {
		// fish.size를 cnt 용도로 사용....
		Queue<Fish> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int cnt = 0;

		queue.offer(new Fish(shark.x, shark.y, cnt));
		visited[shark.x][shark.y] = true;

		while (!queue.isEmpty()) {
			Fish now = queue.poll();

			if (now.x == target.x && now.y == target.y) {
				cnt = now.size;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark.size) {

					queue.add(new Fish(nx, ny, now.size + 1));
					visited[nx][ny] = true;
				}
			}
		}

		return cnt;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void move(Fish removedFish) {
		map[shark.x][shark.y] = 0;
		map[removedFish.x][removedFish.y] = 9;
		shark = new Fish(removedFish.x, removedFish.y, shark.size);
		fishAll.remove(removedFish);
	}

	// 현재 먹을 수 있는 fish list
	private static void getFishList() {
		
		for (Fish fish : fishAll) {
			if(fishList.contains(fish)) continue;
			
			if (fish.size < shark.size)
				fishList.add(fish);
		}

	}

	public static class CustomComparator implements Comparator<Fish> {
		@Override
		public int compare(Fish o1, Fish o2) {
			int d1 = BFS(o1);
			int d2 = BFS(o2);

			if (d1 != d2) return d1 - d2;
			
			return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
		}

	}

	public static class Fish {
		int x, y, size;

		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + "]";
		}
	}

}
