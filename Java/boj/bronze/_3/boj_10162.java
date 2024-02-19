package boj.bronze._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10162 {
	// 전자레인지
	static int t;
	static int[] abc = {300, 60, 10};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<3 ; i++) {
			int temp = t / abc[i];
			sb.append(temp).append(" ");
			t = t - abc[i]*temp;
		}
		
		System.out.println(t != 0 ? -1 : sb);
	}

}
