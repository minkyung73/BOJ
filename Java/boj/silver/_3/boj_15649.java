package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15649 {
	static int n, m;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		visited = new boolean[n+1];
		
		// function call
		recursive(0);
		
		// output
		System.out.println(sb);
	}

	private static void recursive(int k) {
		// basis part
		if(k == m) {
			for (int i : selected)
				sb.append(i).append(" ");
			sb.append("\n");
			return ;
		}
		
		// inductive part
		for(int i=1 ; i<=n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[k] = i;
				recursive(k+1);
				visited[i] = false;
			}
		}
	}
	
	
}
