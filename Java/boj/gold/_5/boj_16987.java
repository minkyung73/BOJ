package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16987 {
	// 계란으로로 계란치기
	static int n;
	static List<Egg> list;
	static int result = 0;
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n input
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		broken = new boolean[n];
		
		// egg input
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Egg(p, w));
		}
		
		// function call
		breakEgg(0, 0);

		System.out.println(result);
	}
	
	public static void breakEgg(int idx, int cnt) {
		System.out.println("idx: " + idx);
		for (Egg egg : list) {
			System.out.println(egg);
		}
		System.out.println("===========================");

		// basis part
		if(list.size() - idx < 2) {
			result = Math.max(result, cnt);
			return ;
		}

		if(list.get(idx).power < 0) return ;

		// inductive part
		for (int i = 0; i < list.size(); i++) {
			if(i == idx) continue;
			if(broken[i]) continue;

			list.get(idx).power -= list.get(i).weight;
			list.get(i).power -= list.get(idx).weight;

			if(list.get(idx).power <= 0 && list.get(i).power > 0) {
				broken[idx] = true;
				breakEgg(i, cnt+1);
				broken[idx] = false;
			} else if(list.get(idx).power > 0 && list.get(i).power <= 0) {
				broken[i] = true;
				breakEgg(idx, cnt+1);
				broken[i] = false;
			} else if(list.get(idx).power <= 0 && list.get(i).power <= 0) {
				broken[idx]	= true;
				broken[i] = true;
				breakEgg(i+1, cnt+2);
				broken[idx]	= false;
				broken[i] = false;
			} else if(list.get(idx).power > 0 && list.get(i).power > 0) {
				continue;
			}

			list.get(idx).power += list.get(i).weight;
			list.get(i).power += list.get(idx).weight;
		}
	}
	
	public static class Egg	 {
		int power;
		int weight;
		
		public Egg(int power, int weight) {
			this.power = power;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Egg{" +
					"power=" + power +
					", weight=" + weight +
					'}';
		}
	}
}
