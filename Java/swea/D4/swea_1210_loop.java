package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1210_loop {
	static int[][] map;
	static boolean[][] visited;
	static int x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 1; i++) {
			// initialize
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];

			// map input
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					
					if(map[j][k] == 2) {
						x = j;
						y = k;
						visited[x][y] = true;
					}
				}
			}
			
			System.out.println("test: " + map[32][97]);

			// function call
			sb.append("#").append(T).append(" ").append(Ladder()).append("\n");
		}

		// output
		System.out.println(sb);
	}

	public static int Ladder() {
		int cnt = 1;
		
		
		while (x != 0) {
			//test
			if(cnt == 20) {
				for(int i=0 ;i<100 ; i++) {
					for(int j=0 ; j<100;  j++) {
						System.out.print(visited[i][j] ? "T " : "F ");
					}
					System.out.println();
				}
			}
			visited[x][y] = true;
			
			if (checkRange(x, y-1) && !visited[x][y-1] && map[x][y-1] == 1) {
				// 왼쪽 길이 있다면
				System.out.println("[L (" + cnt++ + ")]: " + x + " " + y);
				for(int i=y-1 ; i >= 0 ; i--) {
					visited[x][i] = true;
					
//					if(map[x][i] == 0) {
//						y = i+1;
//						break;
//					}
					
					if(checkRange(x, i-1) && map[x][i-1] == 0) {
						y = i;
						break;
					}
				}

			} else if (checkRange(x, y+1) && !visited[x][y+1] && map[x][y+1] == 1) {
				// 오른쪽 길이 있다면 
				System.out.println("[R (" + cnt++ + ")]: " + x + " " + y);
				for(int i=y+1 ; i<100 ; i++) {
					visited[x][i] = true;
					
//					if(map[x][i] == 0) {
//						y = i-1;
//						break;
//					}
					
					if(checkRange(x, i+1) && map[x][i+1] == 0) {
						y = i;
						break;
					}
				}
			} else {
				// 둘다 아니면 위로 올라가
				x--;
				visited[x][y] = true;
			}
		}

		return y;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}
