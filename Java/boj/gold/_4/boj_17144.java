package boj.gold._4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17144 {
	// 미세먼지 안녕!
	static int r, c, t;
	static int[][] map;
	static List<Dust> dustList;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<Point> cleaners;

	public static void main(String[] args) throws IOException {
		init();
		for (int i = 0; i < t; i++) simulation();
		System.out.println(result());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		cleaners = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleaners.add(new Point(i, j));
			}
		}
	}

	public static void simulation() {
		diffusion(); // 1. 미세먼지 확산
		airCleaner(); // 2. 공기청정기 작동
	}
	
	public static void print() {
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void diffusion() {
		// get dustList
		dustList = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) dustList.add(new Dust(i, j, map[i][j]));
			}
		}

		// diffuse dust
		int[][] map_copy = new int[r][c];
		for (Dust dust : dustList) {
			int x = dust.x;
			int y = dust.y;
			
			int num = dust.dust / 5;
			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (checkRange(nx, ny)) {
					map_copy[nx][ny] += num;
					cnt++;
				}
			}

			map_copy[x][y] += dust.dust - num * cnt;
		}

		// copy
		for (int i = 0; i < r; i++) map[i] = map_copy[i].clone();
	}

	public static boolean checkRange(int x, int y) {
		return (x >= 0 && x < r && y >= 0 && y < c) && map[x][y] != -1;
	}

	public static void airCleaner() {
		// 반시계 방향 순환
		
		
		// 시계방향 순환
		
	}
	
	public static int result() {
		int sum = 0;
		
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++) {
				if(map[i][j] == -1) continue;
				sum += map[i][j];
			}
		}
		
		return sum;
	}

	public static class Dust {
		int x, y, dust;

		public Dust(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
