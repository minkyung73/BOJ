package boj.silver._2;

import java.io.*;
import java.util.*;

public class boj_1541 {
	// 잃어버린 괄호
	static String[] minus;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		minus = br.readLine().split("-");
		
		for(int i=0 ; i<minus.length ; i++) {
			String[] plus = minus[i].split("\\+");
			int temp = 0;
			
			for(int j=0 ;j<plus.length ; j++) {
				temp += Integer.parseInt(plus[j]);
			}
			
			if(i == 0) sum += temp;
			else sum -= temp;
		}
		
		System.out.println(sum);
	}
}
