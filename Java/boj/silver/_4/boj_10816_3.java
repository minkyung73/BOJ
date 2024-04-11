package boj.silver._4;

import java.io.*;
import java.util.*;

public class boj_10816_3 {
	// 숫자 카드 2
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		card();
		System.out.println(sb);
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++ )
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
	}
	
	public static void card() throws IOException {
		m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<m ; i++) {
			int num = Integer.parseInt(st.nextToken());
			int res = upperBound(num) - lowerBound(num);
			sb.append(res).append(" ");
		}
	}
	
	public static int upperBound(int key) {
		int l = 0;
		int r = n;
		
		while(l < r) {
			int mid = (l+r) / 2;
			
			if(key >= arr[mid]) l = mid+1;
			else r = mid;
		}
		
		return r;
	}
	
	public static int lowerBound(int key) {
		int l = 0;
		int r = n;
		
		while(l < r) {
			int mid = (l+r) / 2;
			
			if(key <= arr[mid]) r = mid;
			else l = mid+1;
		}
		
		return l;
	}
}
