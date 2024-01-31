package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	// 한빈이와 Spot Mart
	
	static int n, m;
	static int[] arr;
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// initialize
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			res = -1;
			
			// arr input
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			
			// function call
			combination(0, 0, 0);
			
			// result
			sb.append("#").append(i+1).append(" ").append(res).append("\n");
		}
		
		// output
		System.out.println(sb);
	}

	private static void combination(int idx, int k, int sum) {
		// basis part
		if(k == 2) {
			if(sum <= m) res = Math.max(res, sum);
			return ;
		}
		
		// inductive part
		for(int i=idx ; i <n ; i++) {
			combination(i+1, k+1, sum + arr[i]);
		}
	}

}
