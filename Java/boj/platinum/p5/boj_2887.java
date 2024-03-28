package boj.platinum.p5;

import java.io.*;
import java.util.*;

public class boj_2887 {
	// 행성 터널
	
	static int n;
	static Point[] planet;
	static int[] parents;
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(kruskal());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		planet = new Point[n];
		parents = new int[n];
		edgeList = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) parents[i] = i;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
		
			planet[i] = new Point(x, y, z, i);
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
		Point from, to;
		int weight;
		
		public Edge(Point from, Point to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
	
	public static class Point {
		int x, y, z, idx;

		public Point(int x, int y, int z, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", z=" + z + ", idx=" + idx + "]";
		}
		
		
	}
}
