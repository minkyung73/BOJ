package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_6485 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[5001];
			
			for(int j=0 ; j<n ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for(int k=a ; k<=b ; k++) {
					arr[k]++;
				}
			}
			
			sb.append("#").append(i+1).append(" ");
			int p = Integer.parseInt(br.readLine());
			for(int j=0 ;j <p ; j++) {
				int temp = Integer.parseInt(br.readLine());	
				sb.append(arr[temp]).append(" ");
			}
			sb.append("\n");
		}
		
		// output
		System.out.println(sb);
	}

}
