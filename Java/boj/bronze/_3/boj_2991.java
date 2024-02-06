package boj.bronze._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class boj_2991 {
	// 사나운 개 
	static int[][] dog;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// initialize
		dog = new int[2][2];
		
		// dog input
		for(int i=0 ; i<2 ; i++) {
			for(int j=0 ; j<2 ; j++) {
				dog[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// arrive time input
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<3 ; i++) {
			int person = Integer.parseInt(st.nextToken());
			sb.append(attack(person)).append("\n");	// function call
		}
		
		// output
		System.out.println(sb);
	}

	public static int attack(int arrive) {
		int ans = 0, temp;
		
		// dog 1
		temp = arrive;
		temp %= (dog[0][0] + dog[0][1]);
		if(temp != 0 && temp <= dog[0][0]) ans++;
		
		// dog 2
		temp = arrive;
		temp %= (dog[1][0] + dog[1][1]);
		if(temp != 0 && temp <= dog[1][0]) ans++;
		
		return ans;
	}
}
