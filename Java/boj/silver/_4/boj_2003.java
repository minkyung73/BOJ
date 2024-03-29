package boj.silver._4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2003 {
	// 수들의 합 2
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(countSum());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=n ; i++) 
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static int countSum() {
		int cnt = 0;
		int start = 1;
		int end = 1;
		
		while(true) {
			int sum = arr[end] - arr[start-1];
			
			if(sum < m) {
				end++;
			} else if(sum > m) {
				if(start == end) {
					start++;
					end++;
				} else start++;
			} else {
				cnt++;
				start = ++end;
			}
			if(end > n) break;
		}
		
		return cnt;
	}
}
