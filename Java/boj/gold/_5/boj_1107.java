package boj.gold._5;

import java.io.*;
import java.util.*;

public class boj_1107 {
	// 리모컨
	static int n, m;
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(calc());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		broken = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<m ; i++) {
			int idx = Integer.parseInt(st.nextToken());
			broken[idx] = true;
		}
	}
	
	public static int calc() {
		if(n == 100) return 0;
		else if(m == 0) return String.valueOf(n).length();
		
		String str = String.valueOf(n);
		String temp = "";
		
		for(int i=0 ; i<String.valueOf(n).length() ; i++) {
			int num = Integer.parseInt(String.valueOf(str.charAt(i)));
			
			// 고장나지 않았다면
			if(!broken[num]) {
				temp += num;
				continue;
			}

			// 고장났다면
			
		}
		
		return -1;
	}
}
