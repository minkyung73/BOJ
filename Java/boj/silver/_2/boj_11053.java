package boj.silver._2;

import java.util.*;
import java.io.*;

public class boj_11053 {
	// 가장 긴 증가하는 부분 수열
	
	static int n;
	static int[] arr;
	static int[] LIS;
	
	public static void main(String[] args) throws IOException {
		init();
		int res = LIS_DP();
		System.out.println(res);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		LIS = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
	}
	
	public static int LIS_DP() {
		int max = 0;
		
		for(int i=0 ; i<n ; i++) {
			LIS[i] = 1;
			for(int j=0 ; j<i ; j++) {
				if(arr[i] > arr[j]) 
					LIS[i] = Math.max(LIS[i], LIS[j]+1);
			}
			
			max = Math.max(max, LIS[i]);
		}
		
		return max;
	}

}
