package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5356 {
	// 은석이의 세로로 말해요
	static String[] arr;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			
			// initialize
			arr = new String[5];
			len = 0;

			// string input
			for(int j=0 ; j<5 ; j++) {
				arr[j] = br.readLine();
				len = Math.max(len, arr[j].length());
			}
			
			// function call
			sb.append("#").append(i+1).append(" ").append(makeStr()).append("\n");
		}
		
		// output
		System.out.println(sb);
	}

	private static String makeStr() {
		String str = "";
		
		for(int i=0 ; i<len ; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(arr[j].length() <= i) continue;
				str += arr[j].charAt(i);
			}
		}
		
		return str;
	}
}
