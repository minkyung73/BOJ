package boj.bronze._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2999 {
	// 비밀 이메일
	static String str;
	static int len;
	static int r, c;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// initialize
		str = br.readLine();
		len = str.length();
		r = c = 0;
		
		// find r and c
		for(int i = (int) Math.sqrt(len) ; i>= 1 ; i--) {
			if(len % i == 0) {
				r = i;
				c = len / r;
				break;
			}
		}
		
		// initialize and fill the map
		map = new char[r][c];
		int idx = 0;
		for(int i=0 ; i<c ; i++) {
			for(int j=0 ; j<r ; j++) {
				map[j][i] = str.charAt(idx++);
			}
		}
		
		// decoding
		String res = "";
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++) {
				res += map[i][j];
			}
		}
		
		// output
		System.out.println(res);
	}
}
