package boj.gold._3;

import java.io.*;
import java.util.*;

public class boj_16236 {
	// 아기 상어
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static Shark shark;
	static List<Fish> fishList;
	static int time;
	
	public static void main(String[] args) throws IOException {
		init();
		babyShark();
		System.out.println(time);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		fishList = new ArrayList<>();
		time = 0;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
				else if(map[i][j] >= 1 && map[i][j] <= 6) fishList.add(new Fish(i, j, map[i][j], 0));
			}
		}
	}
	
	public static void babyShark() {
		while(true) {			
			Collections.sort(fishList, new Comparator<Fish>() {
				@Override
				public int compare(Fish o1, Fish o2) {
					return Integer.compare(o1.size, o2.size);
				}
			});
			
//			System.out.println("\nfishList");
//			for (Fish fish : fishList) {
//				System.out.println(fish);
//			}
			
			List<Fish> tempList = new ArrayList<>();
			
			for (Fish fish : fishList) {
				if(fish.size >= shark.size) break;
				// if 먹으러 갈 수 있다면, tempList에 추가, 거리 계산
				int dist = checkBFS(fish);
				if(dist != -1) {
					fish.dist = dist;
					tempList.add(fish);
				}
			}
			
//			System.out.println("\ntempList");
//			for (Fish fish : tempList) {
//				System.out.println(fish);
//			}
			
			// tempList 길이에 따라 이동
			int len = tempList.size();
			
			if(len == 0) 
				return ;
			else if(len == 1) {
				Fish fish = tempList.get(0);
				moveShark(fish, tempList);
				fishList.remove(fish);
				map[fish.x][fish.y] = 0;
			}
			else {
				Collections.sort(tempList, new Comparator<Fish>() {
					@Override
					public int compare(Fish o1, Fish o2) {
						if(o1.dist != o2.dist) return Integer.compare(o1.dist, o2.dist);
						else if(o1.x != o2.x) return Integer.compare(o1.x, o2.x);
						else return Integer.compare(o1.y, o2.y);
					}
				});
				
				Fish fish = tempList.get(0);
				moveShark(fish, tempList);
				fishList.remove(fish);
				map[fish.x][fish.y] = 0;
			}
		}
	}
	
	public static int checkBFS(Fish fish) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		
		queue.offer(new int[] {shark.x, shark.y, 0});
		visited[shark.x][shark.y] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == fish.x && now[1] == fish.y) return now[2];
			
			for(int i=0 ; i<4 ; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark.size) {
					queue.offer(new int[] {nx, ny, now[2] + 1});
					visited[nx][ny] = true;
				}
			}
		}
		
		return -1;
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	public static void moveShark(Fish fish, List<Fish> tempList) {
		shark.x = fish.x;
		shark.y = fish.y;
		
		if(shark.cnt+1 == shark.size) {
			shark.cnt = 0;
			shark.size++;
		} else shark.cnt++;
		
		time += fish.dist;
	}
	
	public static class Shark {
		int x, y, size, cnt;

		public Shark(int x, int y, int size, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", cnt=" + cnt + "]";
		}
	}
	
	public static class Fish {
		int x, y, size, dist;

		public Fish(int x, int y, int size, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", dist=" + dist + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(dist, size, x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fish other = (Fish) obj;
			return dist == other.dist && size == other.size && x == other.x && y == other.y;
		}
		
		
	}
}
