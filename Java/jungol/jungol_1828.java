package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol_1828 {
	// 냉장고
	static int n;
	static Ref[] c;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(refrigerator());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		c = new Ref[n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i] = new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(c);
	}
	
	public static int refrigerator() {
		int cnt = 1;
		int low = c[0].low;
		int high = c[0].high;
		
		for(int i=1 ; i<n ; i++) {
			if(c[i].low <= high) {
				low = c[i].low;
				high = Math.min(high, c[i].high);
			}
			else {
				low = c[i].low;
				high = c[i].high;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static class Ref implements Comparable<Ref>{
		int low, high;

		public Ref(int low, int high) {
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Ref o) {
			return this.low != o.low ? this.low - o.low : this.high - o.high;
		}

		@Override
		public String toString() {
			return "Ref [low=" + low + ", high=" + high + "]";
		}
	}

}
