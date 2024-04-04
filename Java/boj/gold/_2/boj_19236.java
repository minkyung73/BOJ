package boj.gold._2;

import java.io.*;
import java.util.*;

public class boj_19236 {
	// 청소년 상어
	static int[][] map;
	static HashMap<Integer, Fish> hashMap;
	static Fish shark;
	static int answer;
	static int firstFish;
	
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static final String[] dir = {"상", "좌상", "좌", "좌하", "하", "우하", "우", "우상"};
	
	public static void main(String[] args) throws IOException {
		init();
		moveShark(map, hashMap, shark, firstFish, 1);
		System.out.println(answer);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		hashMap = new HashMap<>();
		map = new int[4][4];
		answer = 0;
		
		for(int i=0 ; i<4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<4 ; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken())-1;
				
				hashMap.put(a, new Fish(i, j, b));
				map[i][j] = a;
			}
		}
		
		// initialize shark
		int num = map[0][0];
		Fish fish = hashMap.get(num);
		shark = fish;
		firstFish = num;
		
		hashMap.remove(num);
		map[0][0] = 0;
	}
	
	public static void moveShark(int[][] f_map, HashMap<Integer, Fish> f_hashMap, Fish f_shark, int sum, int depth) {
		System.out.println("=============[DEPTH: " + depth + "]=============");
		System.out.println("물고기 이동 전: ");
		print(f_map, f_hashMap, f_shark);
		
		// update answer
		answer = Math.max(answer, sum);
		
		// move fish
		System.out.println("물고기 이동중 ~~ \n");
		Map mm = moveFish(f_map, f_hashMap, f_shark);
		f_map = mm.map;
		f_hashMap = mm.hashMap;
		
		System.out.println("물고기 이동 후: ");
		print(f_map, f_hashMap, f_shark);
		
		// backtracking
		for(int i=1 ;i <4 ; i++) {
			int nx = f_shark.x + dx[f_shark.dir] * i;
			int ny = f_shark.y + dy[f_shark.dir] * i;
			
			// 범위를 벗어나거나 물고기가 없는 곳으로 이동 불가
			if(!checkCondition(nx, ny, f_shark)) continue;
			if(f_map[nx][ny] == 0) continue;
			
			// 원본 복사
			int num = f_map[nx][ny];
			Fish fish = f_hashMap.get(num);
			Fish orgShark = f_shark;
			
			// 상어 이동, 물고기 잡아 먹힘
			f_shark = fish;
			f_map[nx][ny] = 0;
			f_hashMap.remove(num);
			sum += num;
			
			System.out.println("상어(" + orgShark.x + "," + orgShark.y + ")가 " + num + "번 물고기(" + fish.x + "," + fish.y + ") 먹음~~");
			
			// backtracking
			moveShark(f_map, f_hashMap, f_shark, sum, depth + 1);
			
			// 원상 복구
			f_hashMap.put(num, fish);
			f_map[nx][ny] = num;
			f_shark = orgShark;
			sum -= num;
		}
	}
	
	public static Map moveFish(int[][] f_map, HashMap<Integer, Fish> f_hashMap, Fish f_shark) {
		for(int i=1 ; i<=16 ; i++) {
			Fish fish = f_hashMap.get(i);
			if(fish == null) continue;
			
			int fx = fish.x;
			int fy = fish.y;
			
			int nx = fish.x + dx[fish.dir];
			int ny = fish.y + dy[fish.dir];
			
			/*
			 * 물고기가 이동하는 조건
			 * (nx, ny)가 범위 안에 들어야 한다. 
			 * (nx, ny)에 상어가 있으면 안된다.
			 * 
			 * 위의 조건을 만족하지 못하면
			 * 될 때까지 45도 회전
			 * 이동할 수 있는 칸이 없으면 continue
			 * 
			 * 이동할 수 있으면 해당 위치에 있는 물고기와 swap
			 */
			int cnt = 0;
			boolean flag = true;
			while(!checkCondition(nx, ny, f_shark)) {
				if(cnt == 8) {
					flag = false;
					break;
				}
				
				fish.dir++;
				if(fish.dir == 8) fish.dir = 0;
				
				nx = fish.x + dx[fish.dir];
				ny = fish.y + dy[fish.dir];
				
				cnt++;
			}
			
			if(!flag) continue;
			
			// swap
			int num = f_map[nx][ny];
			f_hashMap = swapHash(f_hashMap, i, num, nx, ny);
			f_map = swapMap(f_map, fx, fy, nx, ny);
		}
		
		return new Map(f_map, f_hashMap);
	}
	
	public static int[][] swapMap(int[][] f_map, int x1, int y1, int x2, int y2) {
		int temp = f_map[x1][y1];
		f_map[x1][y1] = f_map[x2][y2];
		f_map[x2][y2] = temp;
		
		return f_map;
	}
	
	public static HashMap<Integer, Fish> swapHash(HashMap<Integer, Fish> f_hashMap, int num1, int num2, int x2, int y2) {
		Fish fish1 = f_hashMap.get(num1);
		Fish fish2 = f_hashMap.get(num2);
		
		int tx = fish1.x;
		int ty = fish1.y;
		
		fish1.x = x2;
		fish1.y = y2;
		
		if(fish2 != null) {			
			fish2.x = tx;
			fish2.y = ty;
		}
		
		return f_hashMap;
	}
	
	public static boolean checkCondition(int x, int y, Fish shark) {
		// 범위를 벗어나면 false
		if(x < 0 || x >= 4 || y < 0 || y >= 4) return false;
		
		// 상어가 있으면 false
		if(shark.x == x && shark.y == y) return false;
		
		return true;
	}
	
	public static void print(int[][] map, HashMap<Integer, Fish> hashMap, Fish shark) {
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {			
				if(i == shark.x && j == shark.y) {
					System.out.print("상어(" + dir[shark.dir] + ")\t");
					continue;
				}
				System.out.print(map[i][j]);
				if(map[i][j] != 0) System.out.print("(" + dir[hashMap.get(map[i][j]).dir]+")\t");
				else System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static class Fish {
		int x, y;
		int dir;
		int sum;
		
		public Fish(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public Fish(int x, int y, int dir, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}
	
	public static class Map {
		int[][] map;
		HashMap<Integer, Fish> hashMap;
		public Map(int[][] map, HashMap<Integer, Fish> hashMap) {
			super();
			this.map = map;
			this.hashMap = hashMap;
		}
	}
}
