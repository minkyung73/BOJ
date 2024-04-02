package boj.gold._5;

import java.io.*;
import java.util.*;

public class boj_11000 {
	// 강의실 배정
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(assignment());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new CustomComparator());
	}
	
	public static class CustomComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
			else return Integer.compare(o1[1], o2[1]);
		}
	}
	
	public static int assignment() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(arr[0][1]);
		
		for(int i=1 ; i<n ; i++) {
			if(arr[i][0] < pq.peek()) pq.offer(arr[i][1]);
			else {
				pq.poll();
				pq.offer(arr[i][1]);
			}
		}
		
		return pq.size();
	}
}
