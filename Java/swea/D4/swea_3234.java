package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3234 {
	// 준환이의 양팔저울
	static int n;
	static int[] weight, selected;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int i=1 ; i<=T ; i++) {
			init(br);
			permutation(0);
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init(BufferedReader br) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		weight = new int[n];
		visited = new boolean[n];
		selected = new int[n];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void permutation(int k) {
		// basis part
		if(k == n) {
			scale(0, 0, 0);
			return ;
		}
		
		// inductive part
		for(int i=0 ; i<n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[k] = weight[i];
				permutation(k+1);
				visited[i] = false;				
			}
		}
	}
	
	// backtracking
	public static void scale(int leftSum, int rightSum, int idx) {
		// basis part
		if(idx == n) {
			cnt++;
			return ;
		}
		
		// inductive part
		if(rightSum + selected[idx] <= leftSum) {
			// 오른쪽에 넣기
			scale(leftSum, rightSum + selected[idx], idx+1);
			
			// 그래도 왼쪽에 넣어주기
			scale(leftSum + selected[idx], rightSum, idx+1);
		}
		else {
			// 왼쪽에 넣기
			scale(leftSum + selected[idx], rightSum, idx+1);
		}
	}
}
