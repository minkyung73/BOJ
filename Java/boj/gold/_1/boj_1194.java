package boj.gold._1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194 {
	// 달이 차오른다, 가자.
	static int n, m;
	static char[][] map;
	static Point minsik;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') minsik = new Point(i, j);
			}
		}
	}

	public static int BFS() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[n][m][64];

		// 상하좌우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		queue.offer(new Node(minsik.x, minsik.y, 0, 0));
		visited[minsik.x][minsik.y][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			
			// 출구인 경우
			if(map[now.x][now.y] == '1') return now.cnt;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (checkRange(nx, ny) 
						&& map[nx][ny] != '#' 
						&& !visited[nx][ny][now.key]) {
					
					// 문인 곳 -> keyMask에서 문에 맞는 키를 갖고 있으면 가 (없으면 못 감)
					if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
						if((now.key & (1 << (map[nx][ny] - 'A'))) >= 1) {
							queue.offer(new Node(nx, ny, now.key, now.cnt+1));
							visited[nx][ny][now.key] = true;
						}
					}
					// 빈칸일 경우, 열쇠인 곳, 출구
					else {
						int tempKey = now.key;

						// 열쇠 있는 곳
						if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f')
							tempKey |= 1 << (map[nx][ny] - 'a');

						queue.offer(new Node(nx, ny, tempKey, now.cnt + 1));
						visited[nx][ny][tempKey] = true;
					}

				}
			}
		}
		
		return -1;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static class Node {
		int x, y, key, cnt;

		public Node(int x, int y, int key, int cnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}
}
