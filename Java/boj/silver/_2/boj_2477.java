package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2477 {
	// 참외밭
	
	static int k;
	static int[] field;
	static int max_width, max_height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// initialize
		k = Integer.parseInt(br.readLine());
		field = new int[6];
		max_width = Integer.MIN_VALUE;
		max_height = Integer.MIN_VALUE;
		
		// field input
		for(int i=0 ; i<6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			field[i] = len;
			
			if(dir == 1 || dir == 2) max_width = Math.max(max_width, len);
			if(dir == 3 || dir == 4) max_height = Math.max(max_height, len);
		}
		
		// find area
		int big_area = max_width * max_height;
		int area1 = (field[1] * field[2]) + (field[4] * field[5]);
		int area2 = Math.abs((field[1] * field[2]) - (field[4] * field[5]));
		
		int res = 0;
		if(area1 > big_area) res = area2;
		else res = area1;
		
		// output
		System.out.println(res * k);
		
	}
}
