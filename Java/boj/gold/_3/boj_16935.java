package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16935 {
	// 배열 돌리기 3
	static int n, m, r;
	static int[][] map;
	static int[] op;

	public static void main(String[] args) throws IOException {
		init();
		rotate();
		print();
	}

	// 상하 반전
	public static void rotate1() {
		int[][] temp = new int[n][m];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				temp[i][j] = map[n - i - 1][j];
			}
		}

		map = temp.clone();
	}

	// 좌우 반전
	public static void rotate2() {
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][m - j - 1];
			}
		}

		map = temp.clone();
	}

	// 오른쪽으로 90도 회전
	public static void rotate3() {
		swap();
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[m - j - 1][i];
			}
		}

		map = temp.clone();
	}

	// 왼쪽으로 90도 회전
	public static void rotate4() {
		swap();
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[j][n - i - 1];
			}
		}

		map = temp.clone();
	}

	// n/2 * m/2 부분 배열로 나눈 후 각 그룹을 시계 방향으로 이동
	public static void rotate5() {
		int[][] temp = new int[n][m];

		// 1번
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				temp[i][j] = map[i + n / 2][j];
			}
		}

		// 2번
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				temp[i][j] = map[i][j - m / 2];
			}
		}

		// 3번
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				temp[i][j] = map[i][j + m / 2];
			}
		}

		// 4번
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				temp[i][j] = map[i - n / 2][j];
			}
		}

		map = temp.clone();

	}

	// n/2 * m/2 부분 배열로 나눈 후 각 그룹을 반시계 방향으로 이동
	public static void rotate6() {
		int[][] temp = new int[n][m];

		// 1번
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				temp[i][j] = map[i][j + m / 2];
			}
		}

		// 2번
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				temp[i][j] = map[i + n / 2][j];
			}
		}

		// 3번
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				temp[i][j] = map[i - n / 2][j];
			}
		}

		// 4번
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				temp[i][j] = map[i][j - m / 2];
			}
		}

		map = temp.clone();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		// initialize
		map = new int[n][m];
		op = new int[r];

		// map input
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 수행해야 할 연산 input
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void rotate() {
		for (int i = 0; i < r; i++) {
			int temp = op[i];

			switch (temp) {
			case 1: {
				rotate1();
				break;
			}
			case 2: {
				rotate2();
				break;
			}
			case 3: {
				rotate3();
				break;
			}
			case 4: {
				rotate4();
				break;
			}
			case 5: {
				rotate5();
				break;
			}
			case 6: {
				rotate6();
				break;
			}
			}
		}
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void swap() {
		int temp = n;
		n = m;
		m = temp;
	}
}
