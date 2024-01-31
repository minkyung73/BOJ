package boj.silver._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1244 {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());
		for(int i=0 ; i<s ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// function call
			func(gender, num);
		}
		
		// output
//		System.out.println("result");
		for(int i=1 ; i<=n ; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
	}
	
	public static void func(int gender, int num) {
		if(gender == 1) {
			for(int i=num ; i<=n ; i+= num) {
				arr[i] = arr[i] == 1 ? 0 : 1;
			}
		}
		else if(gender == 2) {
			int len = 1, idx = 0;
			arr[num] = arr[num] == 1 ? 0 : 1;
			
			while(true) {
				if(num-len < 1 || num+len > n) break;
				
				if(arr[num-len] == arr[num+len]) {
					arr[num-len] = arr[num-len] == 1 ? 0 : 1;
					arr[num+len] = arr[num+len] == 1 ? 0 : 1;
					len++;
				} else break;
				
			}
		}
		
//		for(int i=1 ; i<=n ; i++) System.out.print(arr[i] + " ");
//		System.out.println();
	}

}
