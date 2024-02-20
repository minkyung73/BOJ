package swea.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 정현 swea 1767 프로세서 연결하기
public class test {
	static int N;
	static char[][] map;
	static List<Pair> processorList;
	static int maxCableCnt;
	static int minCableTotalLength;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			processorList = new ArrayList<>();
			maxCableCnt = Integer.MIN_VALUE;
			minCableTotalLength = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j * 2);

					if (map[i][j] == '1')
						processorList.add(new Pair(i, j));
				}

			}

			dfs(0, 0, 0);

			System.out.println("#" + t + " " + minCableTotalLength);
		}
	}

	/*
	 * 
	 * 1. 프로세서들의 좌표를 리스트화
	 * 
	 * 2. 프로세서별로 어느 방향 먼저 탐색하는게 유리한지 설정 // 해주면 좋고 아님 말고
	 * 
	 * 3. 프로세서 하나씩 dfs 돌림. 그런데 프로세서에 연결할 수 있는 전선이 없거나 그냥 전선을 안긋는 경우도 생각해야 함
	 * 
	 * 
	 */

	private static void dfs(int pcIdx, int cableCnt, int totalLength) {
		if (pcIdx == processorList.size()) {
			// 전선 갯수와 길이를 검사 후 업뎃
			if (cableCnt > maxCableCnt) {
				maxCableCnt = cableCnt;
				minCableTotalLength = totalLength;
			} else if (cableCnt == maxCableCnt && totalLength < minCableTotalLength) {
				minCableTotalLength = totalLength;
			}
			return;
		}
		// 만약 이미 전선갯수를 못채우는 게 확정이면 컷
		if (cableCnt + processorList.size() - pcIdx < maxCableCnt) {
			return;
		}
		// 만약 전선 갯수를 딱 맞춰서 채울 수는 있지만 길이가 이미 넘었으면 컷
		if (cableCnt + (processorList.size() - pcIdx) == maxCableCnt && totalLength > minCableTotalLength) {
			return;
		}

		Pair p = processorList.get(pcIdx);
		for (int i = 0; i < 4; i++) {
			if (canNotGo(p.r, p.c, i))
				continue;
			int length = makeCableAndGetLength(p.r, p.c, i);
			dfs(pcIdx + 1, cableCnt + 1, totalLength + length);
			removeCable(p.r, p.c, i);
		}
		dfs(pcIdx + 1, cableCnt, totalLength);

	}

	// direction은 오아왼위 순으로 0, 1, 2, 3
	private static int makeCableAndGetLength(int R, int C, int direction) {
		int length = 0;
		if (direction == 0) {
			for (int c = C + 1; c < N; c++) {
				map[R][c] = '2';
				length++;
			}
		} else if (direction == 1) {
			for (int r = R + 1; r < N; r++) {
				map[r][C] = '2';
				length++;
			}
		} else if (direction == 2) {
			for (int c = C - 1; c >= 0; c--) {
				map[R][c] = '2';
				length++;
			}
		} else if (direction == 3) {
			for (int r = R - 1; r >= 0; r--) {
				map[r][C] = '2';
				length++;
			}
		}

		return length;
	}

	private static void removeCable(int R, int C, int direction) {
		if (direction == 0) {
			for (int c = C + 1; c < N; c++) {
				map[R][c] = '0';
			}
		} else if (direction == 1) {
			for (int r = R + 1; r < N; r++) {
				map[r][C] = '0';
			}
		} else if (direction == 2) {
			for (int c = C - 1; c >= 0; c--) {
				map[R][c] = '0';
			}
		} else if (direction == 3) {
			for (int r = R - 1; r >= 0; r--) {
				map[r][C] = '0';
			}
		}
	}

	private static boolean canNotGo(int R, int C, int direction) {
		if (direction == 0) {
			for (int c = C + 1; c < N; c++) {
				if (map[R][c] != '0')
					return true;
			}
		} else if (direction == 1) {
			for (int r = R + 1; r < N; r++) {
				if (map[r][C] != '0')
					return true;
			}
		} else if (direction == 2) {
			for (int c = C - 1; c >= 0; c--) {
				if (map[R][c] != '0')
					return true;
			}
		} else if (direction == 3) {
			for (int r = R - 1; r >= 0; r--) {
				if (map[r][C] != '0')
					return true;
			}
		}

		return false;
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();

		}
	}
}

class Pair {
	int r, c;

	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
