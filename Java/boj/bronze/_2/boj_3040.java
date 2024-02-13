package boj.bronze._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_3040 {
	// 백설 공주와 일곱 난쟁이
	static int[] arr;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		init();
		find();
		print();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		sum = 0;
		
		for(int i=0 ; i<9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
	}

	public static void find() {
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
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<9 ; i++) {
			if(arr[i] != 0)
				sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
