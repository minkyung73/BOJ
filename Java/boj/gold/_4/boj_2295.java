package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_2295 {
	// 세 수의 합
	static int n, ans;
	static int[] arr, sel;
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		init();
		combi(0, 0);
		System.out.println(ans);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[n];
		sel = new int[3];
		
		for(int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			set.add(arr[i]);
		}
	}
	
	public static void combi(int idx, int k) {
		// basis part
		if(k == 3) {
			System.out.println(Arrays.toString(sel));
			calc();
			return ;
		}
		
		if(idx == n) return ;
		
		// inductive part
		sel[k] = arr[idx];
		combi(idx+1, k+1);
		combi(idx+1, k);
	}
	
	public static void calc() {
		int sum = sel[0] + sel[1] + sel[2];
		if(set.contains(sum)) 
			ans = Math.max(ans, sum);
	}
}
