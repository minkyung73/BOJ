package boj.gold._5;

import java.io.*;
import java.util.*;

public class boj_1759 {
	// 암호 만들기
	static StringBuilder sb = new StringBuilder();
	static int l, c;
	static char[] chars;
	
	public static void main(String[] args) throws IOException {
		init();
		for(int i=0 ; i<c ; i++)
			bt(i, String.valueOf(chars[i]));
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		chars = new char[c];
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<c ; i++)
			chars[i] = st.nextToken().charAt(0);
		Arrays.sort(chars);
	}
	
	public static void bt(int idx, String str) {
		// basis part
		if(idx == c) {
			return ;
		}
		
		if(str.length() == l) {
			// 모음이 하나라도 있는지 check
			if(checkAEIOU(str)) sb.append(str).append("\n");
			return ;
		}
		
		// inductive part
		for(int i=idx+1 ; i<c ; i++) {
			bt(i, str+chars[i]);
		}
	}
	
	public static boolean checkAEIOU(String str) {
		String[] aeiou = {"a", "e", "i", "o", "u"};
		int cnt = 0;	// 모음 체크
		
		for(String c : aeiou) {
			if(str.contains(c)) cnt++;
		}
		
		if(cnt >= 1 && str.length() - cnt >=2) return true;
		return false;
	}

}
