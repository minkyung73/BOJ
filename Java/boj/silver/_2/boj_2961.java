package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961 {
	static int n;
	static Taste[] arr;
	static boolean[] sel;
	static long res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// initialize
		n = Integer.parseInt(br.readLine());
		arr = new Taste[n];
		sel = new boolean[n];
		res = Integer.MAX_VALUE;
		
		// taste input
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Taste(s, b);
		}
		
		// function call
		for(int i=1 ; i<=n ; i++) {
			taste(0, 0, i);
		}
		
		// output
		System.out.println(res);
	}
	
	public static void taste(int cnt, int idx, int k) {
		// basis part
		if(cnt == n) {
			if(idx == k) {				
				int mul = 1, sum = 0;
				for(int i=0 ; i<n ; i++) {
					if(sel[i]) {
						mul *= arr[i].s;
						sum += arr[i].b;
					}
				}
				res = Math.min(res, Math.abs(mul-sum));
			}
			
			return ;
		}
		
		// inductive part
		sel[cnt] = true;
		taste(cnt+1, idx+1, k);
		sel[cnt] = false;
		taste(cnt+1, idx, k);
	}

	public static class Taste {
		int s;
		int b;
		
		public Taste(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
}
