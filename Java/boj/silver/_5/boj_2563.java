package boj.silver._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2563 {
	// 색종이
	static int n;
	static Node[] arr;
	static boolean[][] area = new boolean[101][101];
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		init();
		for(int i=0 ; i<n ; i++) setPaper(arr[i].x, arr[i].y);
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new Node[n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Node(x, y);
		}
	}
	
	public static void setPaper(int x, int y) {
		for(int i=x ; i<x+10 ; i++) {
			for(int j=y ; j<y+10 ; j++) {
				if(!area[i][j]) {
					area[i][j] = true;
					result++;
				}
			}
		}
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
