package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2023 {
	static int n, size;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// initialize
		n = Integer.parseInt(br.readLine());
		size = ((int) Math.pow(10, n)) ;
		
		
		//
		for(int i=2 ; i<9 ; i++) {
			if(prime(i)) find(1, i);
		}
		
		// output
		System.out.println(sb);
	}
	
	private static void find(int digit, int num) {
		// basis part
		if(digit == n) {
			sb.append(num).append("\n");
			return ;
		}
		
		// inductive part
		for(int i= 1 ; i<=9 ; i++) {
			int temp = Integer.parseInt(String.valueOf(num) + String.valueOf(i));
			if(prime(temp)) {
				find(digit+1, temp);
			}
		}
	}

	private static boolean prime(int temp) {
		int cnt = 0;
		for(int i=2 ; i<=Math.sqrt(temp) ; i++) {
			if(temp % i == 0) return false;
		}
		
		return true;
	}

	
}
