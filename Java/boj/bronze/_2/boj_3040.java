package boj.bronze._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_3040 {
	static int[] arr, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[9];
		int sum = 0;
		
		for(int i=0 ; i<9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		L: for(int i=0 ; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++) {
				if(i == j) continue;
				
				int temp = arr[i] + arr[j];
				
				if(sum - temp == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break L;
				}
			}
		}
		
//		Arrays.sort(arr);
		for(int i=0 ; i<9 ; i++) {
			if(arr[i] != 0)
				sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
