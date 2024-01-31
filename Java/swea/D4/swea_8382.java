package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_8382 {
	static int x1, y1, x2, y2;
	static int dx, dy;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// initialize
			ans = 0;
			
			// input 
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			// calculate
			dx = Math.abs(x2-x1);
			dy = Math.abs(y2-y1);
			
			if(dy > dx) swap();	// function call
			
			ans = (dx/2) * 4 + (dx % 2);
			if(dy % 2 == 1) {
				if(dx % 2 == 1) ans++;
				else ans--;
			}
			
			// result
			sb.append("#" + (i+1) + " " + ans + "\n");
		}
		
		// output
		System.out.println(sb);
	}	
	
	public static void swap() {
		int temp = dx;
		dx = dy;
		dy = temp;
	}
}
