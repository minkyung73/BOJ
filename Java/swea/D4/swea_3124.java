package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {
	// 최소 스패닝 트리
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int v, e;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<= T ; i++) {
			init();
			sb.append("#").append(i).append(" ").append(kruskal()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		parents = new int[v+1];
		for(int i=1 ; i<=v ; i++) parents[i] = i;

		edgeList = new Edge[e];		
		for(int i=0 ; i<e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
	}

	public static long kruskal() {
		long weight = 0;
		int cnt = 0;
		
		for (Edge edge : edgeList) {
			// 싸이클을 형성하면 cotninue
			if(!union(edge.from, edge.to)) continue;
			
			// 가중치 추가
			weight += edge.weight;
			
			// 다 연결이 됐다면 break
			if(++cnt == v-1) break;	
		}
		
		return weight;
	}
	
	public static int find(int node) {
		if(node == parents[node]) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static boolean union(int from, int to) {
		int fromRoot = find(from);
		int toRoot = find(to);
		
		if(fromRoot == toRoot) return false;
		
		parents[toRoot] = fromRoot;
		
		return true;
	}
	
	public static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
}
