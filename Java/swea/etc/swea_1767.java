package swea.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class swea_1767 {
	// [SW Test 샘플문제] 프로세서 연결하기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	static TreeSet<Core> cores;
	
	public static void main(String[] args) throws IOException {		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			print();
		}
		System.out.println(sb);
	}
	
	public static void print() {
		for (Core core : cores) {
			System.out.println(core);
		}
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		cores = new TreeSet<>();
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					System.out.println(i + " " + j);
					cores.add(new Core(i, j, getWireLen(i, j))); 
				}
			}
		}
	}
	
	public static class Core implements Comparable<Core>{
		int x, y, len;

		public Core(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public int compareTo(Core o) {
			return this.len - o.len;
		}

		@Override
		public String toString() {
			return "Core [x=" + x + ", y=" + y + ", len=" + len + "]";
		}
	}
	
	public static int getWireLen(int x, int y) {
		int min = Math.min(x, y);
		min = Math.min(min, (n-1-x));
		min = Math.min(min, (n-1-y));
		return min;
	}
	
}
