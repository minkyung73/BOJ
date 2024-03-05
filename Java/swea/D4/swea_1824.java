package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1824 {
    // 혁진이의 프로그램 검증
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static char[][] map;
    static boolean[][][][] visited;
    static boolean flag;
    
    // 상 하 좌 우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            init();
            DFS(new Cursor(0, 0, 3, 0));
        }
        System.out.println(sb);
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C][4][16];
        flag = false;
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }
    
    public static void DFS(Cursor m) {
    	char com = map[m.x][m.y];
    	
    	if(com == '<') {
    		
    	} else if(com == '>') {
    		
    	} else if(com == '^') {
    		
    	} else if(com == 'v') {
    		
    	} else if(com == '_') {
    		
    	} else if(com == '|') {
    		
    	} else if(com == '?') {
    		
    	} else if(com == '.') {
    		int dir = m.dir;
    		int nx = m.x + dx[dir];
    		int ny = m.y + dy[dir];
    		
    		move(nx, ny, dir, m.memory);
    		
    	} else if(com == '@') {
    		flag = true;
    		return ;
    		
    	} else if(com == '+') {
    		int dir = m.dir;
    		int nx = m.x + dx[dir];
    		int ny = m.y + dy[dir];
    		int memory = m.memory == 15 ? 0 : m.memory+1;
    		
    		move(nx, ny, dir, memory);
    		
    	} else if(com == '-') {
    		int dir = m.dir;
    		int nx = m.x + dx[dir];
    		int ny = m.y + dy[dir];
    		int memory = m.memory == 0 ? 15 : m.memory-1;
    		
    		move(nx, ny, dir, memory);
    		
    	} else {	// 숫자인 경우
    		
    	}

    	return ;
    }
    
    public static void move(int x, int y, int dir, int memory) {
    	// 만약에 오른쪽으로 가야하는데 이미 맨 오른쪽이라면
    	if(dir == 3 && y == C) {
    		if(!visited[x][0][dir][memory]) {
				visited[x][0][dir][memory] = true;
    			DFS(new Cursor(x, 0, dir, memory));
    			visited[x][0][dir][memory] = false;
			}
    	}
    	// 일반적인 경우
		else if(checkRange(x, y) && !visited[x][y][dir][memory]) {
			visited[x][y][dir][memory] = true;
			DFS(new Cursor(x, y, dir, memory));
			visited[x][y][dir][memory] = false;
		}
    }
    
    public static boolean checkRange(int x, int y) {
    	return x >= 0 && x < R && y >= 0 && y < C;
    }
    
    public static class Cursor {
    	int x, y, dir, memory;

		public Cursor(int x, int y, int dir, int memory) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.memory = memory;
		}
    }
}
