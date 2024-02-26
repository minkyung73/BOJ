package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1967_2 {
	// 트리의 지름
	static int N;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int a, b;
		long weight;
		
		public Edge(int a, int b, long weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
