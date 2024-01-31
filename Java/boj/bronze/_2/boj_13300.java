package boj.bronze._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class boj_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// initialize
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] score = new int[2][7];
		
		// count score
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			score[s][y]++;
		}
		
		// calculate
		int ans = 0;
		for(int i=0 ;i < 2; i++) {
			for(int j=1 ; j<7 ; j++) {
				int num = score[i][j];
				ans += num / k;
				if(num % k != 0) ans++;
			}
		}
		
		// output
		System.out.println(ans);
	}
}