package swea.D5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1247 {
	// [S/W 문제해결 응용] 3일차 - 최적 경로
	
	static int n;
	static int res;
	static Node company, home;
	static Node[] customers;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			// initialize
			n = Integer.parseInt(br.readLine());
			res = Integer.MAX_VALUE;
			company = new Node(0, 0);
			home = new Node(0, 0);
			customers = new Node[n];
			visited = new boolean[n];
			cnt = 1;
			
			// input for company, home and customers
			StringTokenizer st = new StringTokenizer(br.readLine());
			company.x = Integer.parseInt(st.nextToken());
			company.y = Integer.parseInt(st.nextToken());
			home.x = Integer.parseInt(st.nextToken());
			home.y = Integer.parseInt(st.nextToken());
			for(int j=0 ; j<n ; j++) {
				customers[j] = new Node(0, 0);
				customers[j].x = Integer.parseInt(st.nextToken());
				customers[j].y = Integer.parseInt(st.nextToken());
			}
			
			// 출발 - company
			// 과정 - customers
			// 도착 - home
			permutation(company, 0, 0);
			
			// result
			sb.append("#").append(i+1).append(" ").append(res).append("\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	private static void permutation(Node node, int k, int sum) {
		// basis part		
		if(k == n) {
			res = Math.min(res, sum + calcDist(node, home));
			return;
		}
		
		// inductive part
		/**
		 * 거리 비교
		 * 	처음 고르는 거면 회사와 비교 (k=0)
		 * 	고객 집 갔다가 온 거면 이전 고객 집과 비교 (k = 1 ~ k = n-2)
		 * 	마지막 집이라면 집과 비교 (k=n-1)
		 */
		for(int i=0 ; i<n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation(customers[i], k+1, sum + calcDist(node, customers[i]));
				visited[i] = false;	
			}
		}
		
	}

	public static int calcDist(Node start, Node end) {
		return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
	}

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
