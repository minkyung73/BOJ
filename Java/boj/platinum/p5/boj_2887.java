package boj.platinum.p5;

import java.io.*;
import java.util.*;

public class boj_2887 {
	// 행성 터널
	
	static int n;
	static Point[] planet;
	static int[] parents;
	static List<Edge> edgeList;	// List, PriorityQueue, TreeSet
//	static TreeSet<Edge> edgeList;
//	static PriorityQueue<Edge> edgeList;
	
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
//		edgeList = new TreeSet<>((o1, o2) -> o1.weight - o2.weight);
//		edgeList = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		
		for(int i=0 ; i<n ; i++) parents[i] = i;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());		
			planet[i] = new Point(x, y, z, i);
		}
		
		Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
		for(int i=0 ; i<n-1 ; i++) {
			int w = Math.abs(planet[i].x - planet[i+1].x);
			edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, w));
		}
		
		Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
		for(int i=0 ; i<n-1 ; i++) {
			int w = Math.abs(planet[i].y - planet[i+1].y);
			edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, w));
		}
		
		Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
		for(int i=0 ; i<n-1 ; i++) {
			int w = Math.abs(planet[i].z - planet[i+1].z);
			edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, w));
		}
		
		Collections.sort(edgeList);
		
		print();
	}
	
	public static void print() {
		for (Edge edge : edgeList) {
			System.out.println(edge);
		}
		System.out.println();
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
		int from, to;
		int weight;
		
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

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(from, to, weight);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			return from == other.from && to == other.to && weight == other.weight;
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
