package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_7236 {
	static int n;
	static int[][] map;
	static int res;
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {	
			// initialize
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			res = 1;
			
			// map input
			for(int j=0 ; j<n ;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0 ; k<n ; k++) {
					map[j][k] = st.nextToken().equals("G") ? 0 : 1;							
				}
			}
			
			// function call
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<n ; k++) {
					if(map[j][k] == 1)
						maxDepth(j, k);					
				}
			}
			
			// result
			sb.append("#").append(i+1).append(" ").append(res).append("\n");
		}
		
		// output
		System.out.println(sb);
	}

	private static void maxDepth(int x, int y) {
		int sum = 0;
		for(int i=0 ; i<8 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(checkRange(nx, ny) && map[nx][ny] == 1) {
				sum += map[nx][ny];
			}
		}
		
		res = Math.max(res, sum);
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
