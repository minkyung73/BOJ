package boj.gold._5;

import java.io.*;
import java.util.*;

public class boj_9205_2 {
	// 맥주 마시면서 걸어가기 (BFS)
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=0 ;i <t ; i++) {
			init();
			BFS();
		}
		System.out.println(sb);
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine()) + 2;
		
		nodes = new Node[n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
		
			nodes[i] = new Node(x, y);
		}
	}
	
	public static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		
		queue.offer(new Node(nodes[0].x, nodes[0].y));
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.x == nodes[n-1].x && now.y == nodes[n-1].y) {
				sb.append("happy\n");
				return ;
			}
			
			for(int i=1 ; i<n ; i++) {
				Node next = nodes[i];
				if(!visited[i] && manhattan(now, next)) {
					queue.offer(new Node(next.x, next.y));
					visited[i] = true;
				}
			}
		}

		sb.append("sad\n");
	}
	
	public static boolean manhattan(Node now, Node next) {
		int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
		return dist <= 1000 ? true : false;
	}
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
