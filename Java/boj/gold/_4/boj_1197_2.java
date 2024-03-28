package boj.gold._4;

import java.io.*;
import java.util.*;

public class boj_1197_2 {
	// 최소스패닝 트리
	static int v, e;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(kruskal());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
		edgeList = new Edge[e];
		parents = new int[v+1];
		
		for(int i=1 ; i<=v ; i++) parents[i] = i;
		
		for(int i=0 ; i<e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList);
	}
	
	public static int kruskal() {
		int cnt = 0;
		int weight = 0;
		
		for (Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;
			weight += edge.weight;
			if(++cnt == v-1) break;
		}
		
		return weight;
	}
	
	public static boolean union(int from, int to) {
		int fromRoot = find(from);
		int toRoot = find(to);
		
		if(fromRoot == toRoot) return false;
		parents[fromRoot] = toRoot;
		return true;
	}
	
	public static int find(int node) {
		if(node == parents[node]) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
