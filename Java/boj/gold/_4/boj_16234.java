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
	// 인구 이동

	static int n, l, r;
	static int day;
	static int[][] map;
//	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<List<Node>> list;
	static List<Integer> average;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// initialize
		day = 0;
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		// map input
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 인구 이동
		boolean flag = true;
		while (flag) {
			flag = false;
			list = new ArrayList<>();
			average = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (checkRange(nx, ny) 
								&& checkPopulation(new Node(i, j), new Node(nx, ny)) ) {
							
							BFS(i, j);
							flag = true;
							break;
						}
					}
				}
			}

			if (flag) day++;

//			if(day == 2) {				
//				for (int i = 0; i < list.size(); i++) {
//					for(int j=0 ; j<list.get(i).size() ;j++) {
//						System.out.println(list.get(i).get(j).x + " " + list.get(i).get(j).y);
//					}
//					System.out.println("===========");
//				}
//			}

			// update population
			for (int i = 0; i < average.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					int nx = list.get(i).get(j).x;
					int ny = list.get(i).get(j).y;
					map[nx][ny] = average.get(i);
				}
			}
			
			// 찍어보자
			System.out.println("day: " + day);
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ;j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("===========================");
		}

		System.out.println(day);
	}

	public static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] v = new boolean[n][n];

		queue.offer(new Node(x, y));
		v[x][y] = true;
		list.add(new ArrayList<>());

		int sum = map[x][y];
		int cnt = 1;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			list.get(list.size() - 1).add(now);

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (checkRange(nx, ny) 
						&& checkPopulation(now, new Node(nx, ny)) 
						&& !v[nx][ny]) {

					queue.offer(new Node(nx, ny));
					v[nx][ny] = true;
					sum += map[nx][ny];
					cnt++;
				}
			}
		}

		// calculate average
		int avg = sum / cnt;
		average.add(avg);
	}

	public static boolean checkPopulation(Node now, Node next) {
		int p = map[now.x][now.y];
		int q = map[next.x][next.y];
		int difference = Math.abs(p - q);

		return difference >= l && difference <= r;
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
