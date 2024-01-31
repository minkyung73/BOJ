package boj.bronze._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798 {
	static int n, m;
	static int[] arr;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		res = 0;
		
		// card input
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// function call
		combination(0, 0, 0);
		
		// output
		System.out.println(res);
	}

	private static void combination(int idx, int k, int sum) {
		// basis part
		if(k == 3) {
			res = calc(res, sum);
			return ;
		}
		
		// inductive part
		for(int i=idx ; i<n ; i++) {
			combination(i+1, k+1, sum + arr[i]);
		}
	}

	private static int calc(int n1, int n2) {
		if(n1 > m) return n2;
		else if(n2 > m) return n1;
		
		return Math.abs(m - n1) < Math.abs(m - n2) ? n1 : n2;
	}
	
	
}
