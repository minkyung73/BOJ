package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_2295 {
	// 세 수의 합
	static int n, ans;
	static int[] sel;
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		init();
		combi(0, 0);
		System.out.println(ans);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ans = 0;
		sel = new int[3];
		
		for(int i=0 ; i<n ; i++) {
			map.put(i, Integer.parseInt(br.readLine()));
		}
	}
	
	public static void combi(int idx, int k) {
		// basis part
		if(k == 3) {
//			System.out.println(Arrays.toString(sel));
			calc();
			return ;
		}
		
		if(idx == n) return ;
		
		// inductive part
		sel[k] = map.get(idx);
		combi(idx+1, k+1);
		combi(idx+1, k);
	}
	
	public static void calc() {
		int sum = sel[0] + sel[1] + sel[2];
//		if(map.contains(sum)) 
//			ans = Math.max(ans, sum);
	}
}
