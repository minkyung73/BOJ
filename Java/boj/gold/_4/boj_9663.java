package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_9663 {
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
	
	public static boolean check(int col) {
		for(int i=0 ;i<col ; i++) {
			// 해당 열의 행과 i열의 행이 일치하면 안됨
			if(arr[col] == arr[i]) return false;
			
			// 대각선에 놓여있는 경우
			else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) return false;
		}
		
		return true;
	}
}
