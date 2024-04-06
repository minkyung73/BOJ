package boj.silver._2;

import java.io.*;
import java.util.*;

public class boj_11053_3 {
	// 가장 긴 증가하는 부분 수열
	static int n;
	static int[] arr, lis;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(dp());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		lis = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static int dp() {
		int max = 0;
		
		for(int i=0 ; i<n ; i++) {
			lis[i] = 1;
			for(int j=0 ;j<i ;j++) {
				if(arr[i] > arr[j])
					lis[i] = Math.max(lis[i], lis[j]+1);
			}
			
			max = Math.max(max, lis[i]);
		}
		
		return max;
	}
}
