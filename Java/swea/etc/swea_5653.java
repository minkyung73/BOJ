package swea.etc;

import java.io.*;
import java.util.*;

public class swea_5653 {
	// [모의 SW 역량테스트] 줄기세포배양
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, K;
	static boolean[][] filled;
	static PriorityQueue<Cell> pq;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			breeding();
			sb.append("#").append(i).append(" ");
			sb.append(pq.size()).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		filled = new boolean[N + 2 * K + 1][M + 2 * K + 1];
		pq = new PriorityQueue<>((o1, o2) -> {return o2.HP - o1.HP;});
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) continue;
				
				int x = K + i;
				int y = K + j;
				
				pq.offer(new Cell(x, y, temp, temp));
				filled[x][y] = true;
			}
		}
	}
	
	public static void breeding() {
		for(int i=1 ; i<=K ; i++) {
			ArrayDeque<Cell> dq = new ArrayDeque<>();
			
			while(!pq.isEmpty()) {
				Cell cell = pq.poll();
				cell.time--;
				
				// 일단 음수이면 활성 상태이므로 번식
				if(cell.time < 0) {
					int[] dx = {-1, 1, 0, 0};
					int[] dy = {0, 0, -1, 1};
					
					for(int j=0 ;j<4 ; j++) {
						int nx = cell.x + dx[j];
						int ny = cell.y + dy[j];
						
						if(!filled[nx][ny]) {
							dq.offer(new Cell(nx, ny, cell.HP, cell.HP));
							filled[nx][ny] = true;
						}
					}
				}
				
				// time * -1 == HP 이면 죽은 상태가 되므로 큐에 넣지 않음
				if(cell.time * -1 == cell.HP) continue;
				dq.offer(cell);
			}
			
			while(!dq.isEmpty()) pq.offer(dq.poll());
		}
	}
	
	public static class Cell {
		int x, y, time, HP;

		public Cell(int x, int y, int time, int HP) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.HP = HP;
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", time=" + time + ", HP=" + HP + "]";
		}
	}
}
