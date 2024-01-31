package hdst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hdst_6289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		int[] rank = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j=0 ;j<m ; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//
			if(arr[a] < arr[b]) rank[a]++;
			else if(arr[a] > arr[b]) rank[b]++;
			else {
				rank[a]++;
				rank[b]++;
			}
		}
		
		int cnt = 0;
		for(int i=1 ; i<=n ; i++)
			if(rank[i] == 0) cnt++;
		
		// output
		System.out.println(cnt);
		
	}
}
