
package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_12891 {
	// DNA 비밀번호
	static int s, p;
	static String str;
	static char[] dna = {'A', 'C', 'G', 'T'};
	static int[] nums = new int[dna.length];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// initialize
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		str = br.readLine();
		
		// nums input
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<dna.length ; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		//
		int res = 0;
		for(int i=0 ; i<=s-p ; i++) {
			String temp = str.substring(i, i+p);
			res += password(temp) ? 1 : 0;
		}
		
		// output
		System.out.println(res);
	}

	
	public static boolean password(String str) {
		
		
//		for(int i=0 ; i<dna.length ; i++) {
//			char c = dna[i];
//			int cnt = 0;
//			for(int j=0 ; j<str.length() ; j++) {
//				if(str.charAt(j) == c) cnt++;
//				if(cnt >= nums[i]) break;
//			}
//			
//			if(cnt < nums[i]) return false;
//		}
		
		for(int i=0 ; i<dna.length ;i++) {
			char ch = dna[i];
			int count = (int) str.chars()
					.filter(c -> c == ch)
					.count();
			if(count < nums[i]) return false;
		}
		
		return true;
	}
}