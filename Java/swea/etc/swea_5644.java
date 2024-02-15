package swea.etc;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5644 {
	// [모의 SW 역량테스트] 무선 충전
	
	static int M, A;	// 이동 시간, BC의 개수
	static int[] moveA, moveB;	// 이동 정보
	static Point AA, BB;
	static int sumA, sumB;
	
	// 이동 방향: 상, 우, 하, 좌
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	
	// map
	static boolean[][][] usedBC;
	static List<BC> listBC;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			init(br);
			for(int j=0 ; j<M ; j++) move(i);
		}
	}
	
	public static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		
		AA = new Point(0, 0);
		BB = new Point(9, 9);
		
		moveA = new int[M];
		moveB = new int[M];
		
		sumA = 0;
		sumB = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<M ; i++) moveA[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<M ; i++) moveA[i] = Integer.parseInt(st.nextToken());
		
		//
		usedBC = new boolean[10][10][A];
		map = new int[10][10];
		
		for(int i=0 ; i<A ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			listBC.add(new BC(x, y, c, p));
			fillBC(x, y, c, i);
		}
		
		// 해당 좌표에서 충전할 수 있는 값 구하기
		getP();
	}
	
	public static void fillBC(int x, int y, int c, int num) {
		usedBC[x][y][num] = true;
		
		for(int i=1 ; i<=c ; i++) {
			for(int j=1 ; j<=4 ; j++) {
				int nx = x + dx[j]*i;
				int ny = y + dy[j]*i;
				
				if(checkRange(nx, ny)) 
					usedBC[nx][ny][num] = true;
			}
		}
	}
	
	public static void getP() {
		
		for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				int cnt = 0;
				int sum = 0;
				
				for(int k=0 ; k<A ; k++) {
					if(usedBC[i][j][k]) {
						sum += listBC.get(k).p;
						cnt++;
					}
				}
				
				map[i][j] = cnt == 0 ? 0 : sum / cnt;
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}
	
	public static void move(int sec) {
		AA = new Point(AA.x + dx[moveA[sec]], AA.y + dy[moveA[sec]]);
		BB = new Point(BB.x + dx[moveB[sec]], BB.y + dy[moveB[sec]]);
		
		
	}
	
	public static class BC {
		int x, y, c, p;

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}
