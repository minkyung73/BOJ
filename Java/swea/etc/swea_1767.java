package swea.etc;

import java.awt.Point;
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
	static int[][] map;
	static List<Point> list;
	static int result;
	static int wireMaxCnt;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			connect(0, 0, 0);
			sb.append("#").append(i).append(" ").append(result).append("\n");			
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		list = new ArrayList<>();
		
		result = Integer.MAX_VALUE;
		wireMaxCnt = 0;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 && !alreadyConnected(i, j)) list.add(new Point(i, j));
			}
		}
		
	}
	
	public static boolean alreadyConnected(int x, int y) {
		return x == 0 || x == n - 1 || y == 0 || y == n - 1;
	}

	public static void connect(int idx, int wireCnt, int wireSum) {
		if(idx == list.size()) {
			if(wireCnt > wireMaxCnt) {
				wireMaxCnt = wireCnt;
				result = wireSum;
			} 
			else if(wireCnt == wireMaxCnt) {
				result = Math.min(result, wireSum);
			}
			return ;
		}
		
		Point core = list.get(idx);
		for(int i=0 ; i<4 ; i++) {
			// 해당 방향으로 갈 수 있는지 체크 
			// 갈 수 있으면 전선을 깐다.
			if(canConnect(core.x, core.y, i)) {
				int len = installWire(core.x, core.y, i);
				connect(idx+1, wireCnt+1, wireSum + len);
				removeWire(core.x, core.y, i);
			}
		}
		
		// 모든 방향으로 갈 수 없다면 연결하지 않고 다음 코어로 넘어감
		connect(idx+1, wireCnt, wireSum);
	}

	private static boolean canConnect(int x, int y, int dir) {

		if(dir == 0) {
			for(int i=y+1 ; i<n ; i++) {
				if(map[x][i] != 0) return false;
			}
		}
		else if(dir == 1) {
			for(int i=0 ; i<y ; i++) {
				if(map[x][i] != 0) return false;
			}
		}
		else if(dir == 2) {
			for(int i=x+1 ; i<n ; i++) {
				if(map[i][y] != 0) return false;
			}
		}
		else if(dir == 3) {
			for(int i=0 ; i<x ; i++) {
				if(map[i][y] != 0) return false;
			}
		}
		
		return true;
	}
	
	private static int installWire(int x, int y, int dir) {
		int len = 0;
		
		if(dir == 0) {
			for(int i=y+1 ; i<n ; i++) {
				map[x][i] = 2;
				len++;
			}
		}
		else if(dir == 1) {
			for(int i=0 ; i<y ; i++) {
				map[x][i] = 2;
				len++;
			}
		}
		else if(dir == 2) {
			for(int i=x+1 ; i<n ; i++) {
				map[i][y] = 2;
				len++;
			}
		}
		else if(dir == 3) {
			for(int i=0 ; i<x ; i++) {
				map[i][y] = 2;
				len++;
			}
		}
		
		return len;
	}
	
	private static void removeWire(int x, int y, int dir) {
		
		if(dir == 0) {
			for(int i=y+1 ; i<n ; i++) map[x][i] = 0;
		}
		else if(dir == 1) {
			for(int i=0 ; i<y ; i++) map[x][i] = 0;
		}
		else if(dir == 2) {
			for(int i=x+1 ; i<n ; i++) map[i][y] = 0;
		}
		else if(dir == 3) {
			for(int i=0 ; i<x ; i++) map[i][y] = 0;
		}
		
	}
	
	public static void print() {
		for(int i=0 ; i<n ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("===================");
	}
}
