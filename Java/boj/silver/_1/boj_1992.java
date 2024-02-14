package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
	// 쿼드 트리
	static int n;
	static int[][] map;
	static String res;
	
	public static void main(String[] args) throws IOException {
		init();
		quad(0, 0, n);
		System.out.println(res);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		res = "";
		
		for(int i=0 ; i<n ;i++) {
			String str = br.readLine();
			for(int j=0 ; j<n ; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		
	}

	public static void quad(int x, int y, int size) {
		int num = map[x][y];
		
		for(int i=x ; i<x + size ; i++) {
			for(int j=y ; j< y + size ;j++) {
				if(map[i][j] != num) {
					res += "(";
					size /= 2;
					quad(x, y, size);
					quad(x, y + size, size);
					quad(x + size, y, size);
					quad(x + size, y + size, size);
					res += ")";
					return ;
				}
			}
		}
		
		// 같으면
		res += num;
	}
}
