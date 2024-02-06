package boj.silver._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1094 {
	// 막대기
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i=0 ; i<7 ; i++) {
			if((x & (1 << i)) > 0) cnt++;
		}
		
		System.out.println(cnt);
	}
}
