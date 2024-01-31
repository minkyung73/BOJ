package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class swea_1218 {
	// 괄호 짝짓기
	static int n;
	static String str;
	static List<Character> left = Arrays.asList('(', '{', '[', '<');
	static List<Character> right = Arrays.asList(')', '}', ']', '>');
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=10 ; i++) {
			// input
			n = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			// function call
			sb.append("#").append(i).append(" ").append(bracket()).append("\n");
			
		}
		
		// output
		System.out.println(sb);
	}

	
	public static int bracket() {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0 ; i<n ; i++) {
			char c = str.charAt(i);
			
			if(left.contains(c)) stack.push(c);
			else {
				if(stack.isEmpty()) return 0;
				
				int idxR = right.indexOf(c);
				int idxL = left.indexOf(stack.peek());
				
				if(idxL == idxR) stack.pop();
				else return 0;
			}
		}
		
		if(!stack.isEmpty()) return 0;
		
		return 1;
	}
}
