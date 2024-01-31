package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.StringTokenizer;

public class swea_5215 {
	// 햄버거 다이어트
	static int n, l, max;
	static Hamburger[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// initialize
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new Hamburger[n];
			visited = new boolean[n];
			max = 0;
			
			// 맛에 대한 점수와 칼로리 저장
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				arr[j] = new Hamburger(t, k);
			}
			
			// 조합 구하며 최대 점수 갱신
			for (int j = 1; j <= n; j++) {
				// function call
				combination(arr, visited, 0, j);
			}
			
			sb.append("#" + (i+1) + " " + max + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void combination(Hamburger[] arr, boolean[] visited, int start, int r) {
		if(r == 0) {
			int[] res = calc(arr, visited);
			if(res[1] <= l) max = Math.max(max,  res[0]);
			return ;
		}
		else {
			for(int i=start ; i<arr.length ; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, r-1);
				visited[i] = false;
			}
		}
	}
	
	public static int[] calc(Hamburger[] arr, boolean[] visited) {
		int score = 0, kcal = 0;
		int res[] = new int[2];

		for (int i = 0; i < arr.length ; i++) {
			if(visited[i] == true) {
				score += arr[i].t;
				kcal += arr[i].k;
			}
		}
		
		res[0] = score;
		res[1] = kcal;
		
		return res;
	}
	
	public static class Hamburger {
		int t, k;

		public Hamburger(int t, int k) {
			super();
			this.t = t;
			this.k = k;
		}
	}
}
