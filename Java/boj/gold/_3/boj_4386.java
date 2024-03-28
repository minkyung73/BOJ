package boj.gold._3;

import java.io.*;
import java.util.*;

public class boj_4386 {
	// 별자리 만들기
	
	static int n;
	static int[] parents;
	static List<Edge> edgeList;
	static Point[] stars;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(kruskal());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		parents = new int[n];
		edgeList = new ArrayList<>();
		stars = new Point[n];
		
		for(int i=0 ; i<n ; i++) parents[i] = i;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
		
			stars[i] = new Point(x, y, i);
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=i+1 ; j<n ; j++) {
				Point from = stars[i];
				Point to = stars[j];
				double weight = getWeight(from, to);
				edgeList.add(new Edge(from, to, weight));
			}
		}
		Collections.sort(edgeList);
	}
	
	public static double kruskal() {
		int cnt = 0;
		double weight = 0;
		
		for (Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;
			weight += edge.weight;
			if(++cnt == n-1) break;
		}
		
		return Math.round(weight * 100) / 100.0;
//		return weight;
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
	
	public static double getWeight(Point from, Point to) {
		return Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
	}

	public static class Edge implements Comparable<Edge> {
		Point from, to;
		double weight;

		public Edge(Point from, Point to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	
	}
	
	public static class Point {
		double x, y;
		int idx;

		public Point(double x, double y, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
