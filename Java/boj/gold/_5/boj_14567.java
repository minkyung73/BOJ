package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14567 {
	// 선수과목 (Prerequisite)
	static int n, m;
	static int[] degree, result;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		init();
		graph();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree = new int[n+1];
		result = new int[n+1];
		
		list = new ArrayList[n+1];
		for(int i=0 ; i<n ; i++) list[i] = new ArrayList<>();
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
	
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			degree[v]++;
		}
	}

	public static void graph() {
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입차수가 0인 과목 (선수과목이 없는 과목)
		for(int i=1 ; i<=n ; i++) {
			if(degree[i] == 0) queue.offer(i);
		}
		
		//
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
		}
	}
}
