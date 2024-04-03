package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_9663_2 {
	// N-Queen
	static int N;
	static int[] arr;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		nQueen(0);
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		// basis part
		if(depth == N) {
			cnt++;
			return ;
		}
		
		// inductive part
		for(int i=0 ; i<N ; i++) {
			arr[depth] = i;
			if(check(depth)) nQueen(depth+1);
		}
	}

	public static boolean check(int row) {
		for(int i=0 ; i<row ; i++) {
			if(arr[row] == arr[i]) return false;
			if(Math.abs(arr[row] - arr[i]) == Math.abs(row - i)) return false;
		}
		
		return true;
	}
}
