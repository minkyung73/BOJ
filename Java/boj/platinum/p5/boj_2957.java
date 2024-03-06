package boj.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class boj_2957 {
	// 이진 탐색 트리
	static int N;
	static TreeSet<Integer> tree;
	static int[] depth;
	static long cnt;
	
	public static void main(String[] args) throws IOException {
		init();
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		tree = new TreeSet<>();
		depth = new int[N+2];
		cnt = 0;
		
		tree.add(0);
		tree.add(N+1);
		
		depth[0] = -1;
		depth[N+1] = -1;
		
		for(int i=1 ; i<=N ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			tree.add(num);
			depth[num] += Math.max(depth[tree.lower(num)], depth[tree.higher(num)]) + 1;
			cnt += depth[num];
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
