package boj.gold._2;

import java.util.*;
import java.io.*;

public class boj_12738 {
	// 가장 긴 증가하는 부분 수열 3
	
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
		LIS[0] = arr[0];
		int len = 1;
		
		for(int i=1 ; i<n ; i++) {
			int key = arr[i];
			
			if(key > LIS[len-1]) {
				LIS[len++] = key;
			} else {
				// lower bound
				
				int low = 0;
				int high = len-1;
				
				while(low < high) {
					int mid = (low + high) / 2;
					
					if(key > LIS[mid])
						low = mid+1;
					else
						high = mid;
				}
				
				LIS[low] = key;
			}
		}
		
		return len;
	}

}
