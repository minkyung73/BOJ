package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_21758 {
	// 꿀 따기
	static int N;
	static int[] arr, bees;
	static int beehive;
	static int result;
	
	public static void main(String[] args) throws IOException {
		init();
		combination(1, 0);
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];		
		bees = new int[2];
		result = 0;
		
		for(int i=1 ; i<=N ; i++) arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
	}

	// 벌이 있는 위치 조합 구하기
	public static void combination(int idx, int k) {
		// basis part
		if(k==2) {
			// 벌통이 있는 위치
			if(Math.abs(bees[0] - bees[1]) == 1) {
				if(bees[0] != 1) {
					beehive = 1;
					int res = calc();
					result = Math.max(result, res);		
					
//					System.out.println(Arrays.toString(bees));
//					System.out.println(beehive);
//					System.out.println(res);
//					System.out.println("===================");
				}
				
				if(bees[1] != N) {
					beehive = N;
					int res = calc();
					result = Math.max(result, res);		
					
//					System.out.println(Arrays.toString(bees));
//					System.out.println(beehive);
//					System.out.println(res);
//					System.out.println("===================");
				}
				
				return ;
			}
			
			
			
			// 가운데인 경우
			boolean[] isBees = new boolean[N+1];
			isBees[bees[0]] = true;
			isBees[bees[1]] = true;
			for(int i=1 ; i<=N ; i++) {
				if(!isBees[i]) {
					beehive = i;
					int res = calc();
					result = Math.max(result, res);
					
//					System.out.println(Arrays.toString(bees));
//					System.out.println(beehive);
//					System.out.println(res);
//					System.out.println("===================");
				}
			}
			
			return ;
		}
		
		if(idx == arr.length) return ;
		
		// inductive part
		bees[k] = idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	
	public static int calc() {
		int sum = 0;
		
		for(int i=0 ; i<2 ; i++) {
			int bee = bees[i];
			int another = i == 0 ? bees[1] : bees[0];
			
//			int temp = Math.abs(arr[beehive] - arr[bee-1]);
			
			int temp = 0;
			if (bee < beehive) {
				temp = arr[beehive] - arr[bee-1];
				temp -= arr[bee] - arr[bee-1];
				
			} else {
				temp = arr[bee-1] - arr[beehive-1];
//				temp -= arr[bee] - arr[bee-1];
			}
			
			// 그 사이에 다른 벌이 있다면 또 빼줘
			if((bee < beehive) 
					&& (another > bee) && (another < beehive)) {
				temp -= arr[another] - arr[another-1];
			} else if((bees[i] > beehive) 
					&& (another < bee) && (another > beehive)) {
				temp -= arr[another] - arr[another-1];
			}
			
			sum += temp;
		}
		
		
		
		return sum;
	}
}
