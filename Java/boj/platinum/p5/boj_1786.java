package boj.platinum.p5;

import java.io.*;
import java.util.*;

public class boj_1786 {
	// 찾기
	static StringBuilder sb = new StringBuilder();
	static String T, P;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		init();
		kmp(T, P);
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = br.readLine();
		P = br.readLine();
		
		cnt = 0;
	}
	
	public static int[] makeTable(String P) {
		int len = P.length();
		int[] table = new int[len];
		
		int idx = 0;
		for(int i=1 ; i<len ; i++) {
			while(idx > 0 && P.charAt(i) != P.charAt(idx))
				idx = table[idx-1];
			
			if(P.charAt(i) == P.charAt(idx))
				table[i] = ++idx;
		}
		
		return table;
	}
	
	public static void kmp(String T, String P) {
		int[] table = makeTable(P);
		
		int len1 = T.length();
		int len2 = P.length();
		
		int idx = 0;
		
		for(int i=0 ; i<len1 ; i++) {
			while(idx > 0 && T.charAt(i) != P.charAt(idx))
				idx = table[idx-1];
			
			if(T.charAt(i) == P.charAt(idx)) {
				if(idx == len2-1) {
					sb.append(i-idx+1).append(" ");				
					cnt++;
					idx = table[idx];
				}
				else idx++;
			}
		}
	}
}
