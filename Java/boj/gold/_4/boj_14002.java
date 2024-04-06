package boj.gold._4;

import java.util.*;
import java.io.*;

public class boj_14002 {
	// 가장 긴 증가하는 부분 수열 4
	static int n;
	static int[] arr;
	static int[] LIS;
	static int max;
	
	public static void main(String[] args) throws IOException {
		init();
		LIS_DP();
		print();
	}
	

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		max = 0;
		arr = new int[n];
		LIS = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
	}

	private static void LIS_DP() {
		for(int i=0 ; i<n ; i++) {
			LIS[i] = 1;
			
			for(int j=0 ;j <i ;j++) {
				if(arr[i] > arr[j]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
			
			max = Math.max(max, LIS[i]);
		}
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<n ; i++) {
			sb.append(LIS[i] + " ");
		}
		System.out.println(sb);

		for(int i=n-1 ; i>=0 ; i--) {
			
		}
		
	}
}
