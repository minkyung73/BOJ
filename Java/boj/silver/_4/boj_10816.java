package boj.silver._4;

import java.io.*;
import java.util.*;

public class boj_10816 {
	// 숫자 카드 2
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		init();
		find();
		System.out.println(sb);
	}

	public static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ;i <n ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num) == null) map.put(num, 1);
			else map.put(num, map.get(num)+1);
		}
	}
	
	public static void find() throws IOException {
		m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<m ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num) == null) sb.append("0 ");
			else sb.append(map.get(num)).append(" ");
		}
	}
}
