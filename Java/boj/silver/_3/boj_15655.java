package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15655 {
	// N과 M (5) - 순열
	static int n, m;
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		// function call
		recursive(0, 0);

		// output
		System.out.println(sb);
	}

	private static void recursive(int k, int idx) {
		// basis part
		if (k == m) {
			for (int i : selected)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		// inductive part
		for (int i = idx; i < n; i++) {
			if(!visited[i]) {				
				visited[i] = true;
				selected[k] = arr[i];
				recursive(k + 1, i);
				visited[i] = false;
			}
		}
	}

}
