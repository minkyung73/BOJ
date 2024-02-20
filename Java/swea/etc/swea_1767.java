package swea.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {
	// [SW Test 샘플문제] 프로세서 연결하기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int result;
	static int[][] map;
	static List<Core> list;

	// 동 서 남 북
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			init();
			connect(0, 0);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		result = Integer.MAX_VALUE;
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1 && !alreadyConnected(i, j)) {
					list.add(new Core(i, j));
				}
			}
		}
	}

	public static boolean alreadyConnected(int x, int y) {
		return x == 0 || x == n - 1 || y == 0 || y == n - 1;
	}

	public static void connect(int idx, int wireSum) {
		// 모두 연결 했으면 update result
		if(idx == list.size()) {
			result = Math.min(result, wireSum);
			return ;
		}
		
		// 더이상 탐색할 필요가 없으므로 return
		if(wireSum >= result) return;
		
		// backtracking
		Core core = list.get(idx);
		for(int i=0 ; i<4 ; i++) {
			int len = getWireLen(core.x, core.y, i);
			if(len == -1) {
				removeWire(core.x, core.y, i);
				continue;
			}
			connect(idx+1, wireSum + len);
			removeWire(core.x, core.y, i);
		}
	}
	
	public static int getWireLen(int x, int y, int dir) {
		int len = 0;
		
		if(dir == 0) {
			for(int i=y+1 ; i<n ; i++) {
				if(map[x][i] != 0) return -1;
				map[x][i] = 2;
				len++;
			}
		}
		else if(dir == 1) {
			for(int i=0 ; i<y ; i++) {
				if(map[x][i] != 0) return -1;
				map[x][i] = 2;
				len++;
			}
		}
		else if(dir == 2) {
			for(int i=x+1 ; i<n ; i++) {
				if(map[i][y] != 0) return -1;
				map[i][y] = 2;
				len++;
			}
		}
		else if(dir == 3) {
			for(int i=0 ; i<x ; i++) {
				if(map[i][y] != 0) return -1;
				map[i][y] = 2;
				len++;
			}
		}
		
		return len;
	}

	public static void removeWire(int x, int y, int dir) {
		if(dir == 0) {
			for(int i=y+1 ; i<n ; i++) {
				if(map[x][i] == 2) map[x][i] = 0;
			}
		}
		else if(dir == 1) {
			for(int i=0 ; i<y ; i++) {
				if(map[x][i] == 2) map[x][i] = 0;
			}
		}
		else if(dir == 2) {
			for(int i=x+1 ; i<n ; i++) {
				if(map[i][y] == 2) map[i][y] = 0;
			}
		}
		else if(dir == 3) {
			for(int i=0 ; i<x ; i++) {
				if(map[i][y] == 2) map[i][y] = 0;
			}
		}
	}

	public static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Core [x=" + x + ", y=" + y + "]";
		}
	}
}
