package boj.gold._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252 {
	// 줄 세우기
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static ArrayList<Integer>[] list;
	static int[] degree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		init();
		topologicalSort();
		System.out.println(sb);
	}

	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		degree = new int[n+1];
		visited = new boolean[n+1];

		list = new ArrayList[n+1];
		for(int i=0 ; i<=n ; i++) list[i] = new ArrayList<>();
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			degree[v]++;
		}
	}

	public static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입 차수가 0이면 queue 에 삽입
		for(int i=1 ; i<=n ; i++) {
			if(degree[i] == 0) queue.offer(i);
		}
		
		//
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			sb.append(now).append(" ");
			visited[now] = true;
			
			for(int i=0 ; i<list[now].size() ; i++) {
				int temp = list[now].get(i);
				degree[temp]--;
				if(degree[temp] == 0) queue.offer(temp);
			}
		}
		
		// 정렬에 구애받지 않는 학생
		for(int i=1 ; i<=n ; i++) {
			if(!visited[i]) sb.append(i).append(" ");
		}
	}
}
