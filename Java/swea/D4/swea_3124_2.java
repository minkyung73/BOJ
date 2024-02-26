package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			sb.append("#").append(i).append(" ");
			sb.append(kruskal()).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		for(int i=1 ; i<=V ; i++) parents[i] = i;
	
		edgeList = new Edge[E];
		for(int i=0 ; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(a, b, w);
		}
		Arrays.sort(edgeList);
	}
	
	public static long kruskal() {
		int cnt = 0;
		long weight = 0;
		
		for (Edge edge : edgeList) {
			if(!union(edge.a, edge.b)) continue;
			
			weight += edge.weight;
			
			if(++cnt == V-1) break;
		}
		
		return weight;
	}
	
	public static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if(ra == rb) return false;
		
		parents[ra] = rb;
		return true;
	}
	
	public static int find(int node) {
		if(parents[node] == node) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static class Edge implements Comparable<Edge>{
		int a, b;
		long weight;

		public Edge(int a, int b, long weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
}
