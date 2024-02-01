package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215_subset {
	static int n, l;
	static Hamburger[] arr;
	static boolean[] sel;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1 ; i<=T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// initialize
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new Hamburger[n];
			sel = new boolean[n];
			res = 0;
			
			// hamburger input
			for(int j=0 ; j<n ; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				arr[j] = new Hamburger(s, k);
			}
			
			// function call
			subset(0, 0);
			
			// result
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	private static void subset(int cnt, int sum) {
		// basis part
		int score = 0;
		if(cnt == n) {
			if(sum <= l) {
				for(int i=0 ; i<n ; i++) {
					if(sel[i]) {
						score += arr[i].score;
					}
				}
				res = Math.max(res, score);
			}	
			return ;
		}
				
		// inductive part
		sel[cnt] = true;
		subset(cnt+1, sum + arr[cnt].kcal);
		sel[cnt] = false;
		subset(cnt+1, sum);
	}
	
	public static class Hamburger {
		int score;
		int kcal;

		public Hamburger(int score, int kcal) {
			this.score = score;
			this.kcal = kcal;
		}
	}
}
