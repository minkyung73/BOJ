package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16918 {
	
	static int r, c, n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());		
		int[][] map = new int[r][c];
		
		// map input
		for(int i=0 ; i<r ; i++) {
			String str = br.readLine();
			for(int j=0 ;j<c ; j++) {
				map[i][j] = str.charAt(j) == '.' ? 0 : 1;
			}
		}
		
		// bomb
		
		
	}

}
