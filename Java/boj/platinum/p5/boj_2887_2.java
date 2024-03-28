package boj.platinum.p5;

import java.io.*;
import java.util.*;

public class boj_2887_2 {
	// 행성 터널
	
	static int n;
	static int[][] planet;
	static int[] parents;
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(kruskal());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		planet = new int[n][3];
		parents = new int[n];
		edgeList = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) parents[i] = i;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			planet[i][0] = Integer.parseInt(st.nextToken());
			planet[i][1] = Integer.parseInt(st.nextToken());
			planet[i][2] = Integer.parseInt(st.nextToken());
		
		}
		
		for(int i=0 ;i <n ; i++ ) {
			for(int j=i+1 ; j<n ; j++) {
				int weight = getWeight(planet[i], planet[j]);
				edgeList.add(new Edge(planet[i], planet[j], weight));
			}
		}
		Collections.sort(edgeList);
		
		for (Edge edge : edgeList) {
			System.out.println(edge);
		}
	}
	
	public static int getWeight(Point from, Point to) {
		int min = Math.min(Math.abs(from.x - to.x), Math.abs(from.y - to.y));
		return Math.min(min, Math.abs(from.z - to.z));
	}
	
	public static int kruskal() {
		int weight = 0;
		int cnt = 0;
		
		for (Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;
			weight += edge.weight;
			if(++cnt == n-1) break;
		}
		
		return weight;
	}
	
	public static boolean union(Point from, Point to) {
		int fromRoot = find(from.idx);
		int toRoot = find(to.idx);
		
		if(fromRoot == toRoot) return false;
		parents[fromRoot] = toRoot;
		return true;
	}
	
	public static int find(int node) {
		if(node == parents[node]) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static class Edge implements Comparable<Edge> {
		int fromX, fromY, fromZ;
		int toX, toY, toZ;
		int weight;

		public Edge(int fromX, int fromY, int fromZ, int toX, int toY, int toZ, int weight) {
			super();
			this.fromX = fromX;
			this.fromY = fromY;
			this.fromZ = fromZ;
			this.toX = toX;
			this.toY = toY;
			this.toZ = toZ;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
