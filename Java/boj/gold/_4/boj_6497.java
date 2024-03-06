package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6497 {
	// 전력난
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int m, n;
	static Node[] EdgeList;
	static int[] parents;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m==0 && n == 0) break;
			
			init();
			sb.append(sum - kruskal()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		EdgeList = new Node[n];
		parents = new int[m];
		sum = 0;
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			EdgeList[i] = new Node(x, y, z);
			sum += z;
		}
		Arrays.sort(EdgeList);
		
		for(int i=0 ; i<m ; i++) parents[i] = i;
	}
	
	public static long kruskal() {
		int cnt = 0;
		long weight = 0;
		
		for (Node node : EdgeList) {
			
			if(!union(node.x, node.y)) continue;
			weight += node.z;
			if(cnt == m-1) break;
		}
		
		return weight;
	}
	
	public static boolean union(int from, int to) {
		int fromRoot = find(from);
		int toRoot = find(to);
		
		if(fromRoot == toRoot) return false;
		if(fromRoot < toRoot) parents[toRoot] = fromRoot;
		else parents[fromRoot] = toRoot;
		return true;
	}
	
	public static int find(int node) {
		if(node == parents[node]) return node;
		return parents[node] = find(parents[node]);
	}
	
	public static class Node implements Comparable<Node> {
		int x, y, z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.z, o.z);
		}
	}

}
