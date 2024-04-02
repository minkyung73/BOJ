package boj.silver._2;

import java.io.*;
import java.util.*;

public class boj_18870_2 {
	// 좌표 압축 
	static int n;
	static int[] arr, sorted;
	
	public static void main(String[] args) throws IOException {
		init();
		compression();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		sorted = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) {
			sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
	}
	
	public static void compression() {
		int rank = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0 ; i<n ; i++) {
			if(!map.containsKey(sorted[i]))
				map.put(sorted[i], rank++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<n ; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}
