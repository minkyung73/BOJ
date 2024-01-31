package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {
	static StringBuilder sb = new StringBuilder();
	static int h, w;
	static char[][] map;
	static int x, y; // 전차의 위치
	static char d; // 전차가 바라보는 방향
	static char[] dir = {'U', 'D', 'L', 'R'};
	static char[] tank = {'^', 'v', '<', '>'};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// initialize
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			sb.append("#").append(i + 1).append(" ");

			// map input
			for (int j = 0; j < h; j++) {
				String str = br.readLine();
				for (int k = 0; k < w; k++) {
					map[j][k] = str.charAt(k);

					// 전차 발견 시 좌표, 방향 저장	
					for(int l=0 ; l<4 ; l++) {
						if(map[j][k] == tank[l]) {
							d = dir[l];
							x = j;
							y = k;
						}
					}
				}
			}

			// user input & game function call
			int n = Integer.parseInt(br.readLine());
			String user = br.readLine();
			for (int j = 0; j < n; j++) {
				game(user.charAt(j));	// function call
			}

			// result of map
			print();
		}

		// output
		System.out.println(sb);
	}
	
	public static void print() {
		for(int i=0 ; i<h ; i++) {
			String str = "";
			for(int j = 0 ; j<w ; j++) 
				str += map[i][j];
			sb.append(str).append("\n");
		}
	}

	public static void game(char c) {
		// 1. 입력값이 방향인 경우
		for(int i=0 ; i<4 ; i++) {
			if(dir[i] == c) {
				map[x][y] = tank[i];
				d = dir[i];
				
				// 전차 이동 가능할 경우 이동
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(checkRange(nx, ny) && map[nx][ny] == '.') {
					map[x][y] = '.';
					x = nx;
					y = ny;
					map[nx][ny] = tank[i];
				}
			}
		}
		
		// 2. 입력값이 shoot인 경우
		if(c == 'S') shoot();
	}
	
	public static void shoot() {
		// 탐색
		if(d == 'U') {
			for(int i = x ; i>=0 ; i--) {
				if(map[i][y] == '#') break;
				else if(map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
			}
		}
		else if(d == 'D') {
			for(int i=x ; i<h ; i++) {
				if(map[i][y] == '#') break;
				else if(map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
			}
		}
		else if(d == 'L') {
			for(int i=y ; i>=0 ; i--) {
				if(map[x][i] == '#') break;
				else if(map[x][i] == '*') {
					map[x][i] = '.';
					break;
				}
			}
		}
		else if (d == 'R') {
			for(int i=y ; i<w ; i++) {
				if(map[x][i] == '#') break;
				else if(map[x][i] == '*') {
					map[x][i] = '.';
					break;
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}
}
