package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16918 {

	static int r, c, n;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// r, c and n input
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		// initialize
		map = new int[r][c];

		// map input
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j) == '.' ? -1 : 1;
			}
		}

		// bomb
		for (int i = 2; i <= n; i++) {
			updateCount();
			bomb();
		}

		// output
		print();
	}

	public static void bomb() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 3) {
					map[i][j] = -1;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (checkRange(nx, ny) && map[nx][ny] != 3)
							map[nx][ny] = -1;
					}
				}
			}
		}
	}

	public static void updateCount() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == -1)
					map[i][j] = 0;
				else
					map[i][j]++;
			}
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(map[i][j] == -1 ? '.' : 'O');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
