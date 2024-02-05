package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {
	static int n, command;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=10 ; i++) {
			
			// 원본 암호문의 길이
			n = Integer.parseInt(br.readLine());
			
			// 원본 암호문
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			for(int j=0 ; j<n ;j ++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어 개수
			command = Integer.parseInt(br.readLine());
			
			// 명령어
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<command ; j++) {
				st.nextToken();	// I
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int[] s = new int[y];
				
				for(int k=0 ; k<y ; k++) {
					s[k] = Integer.parseInt(st.nextToken());
				}
				
				// function call
				push(x, y, s);
			}
			
			// StringBuilder
			sb.append("#").append(i).append(" ");
			for (int j=0 ; j<10 ; j++) sb.append(list.get(j)).append(" ");
			sb.append("\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	public static void push(int x, int y, int[] s) {
		List<Integer> temp = new ArrayList<>();
		
		for(int i=0 ; i<x ; i++) {
			temp.add(list.get(i));
		}
		
		for(int i=0 ; i<s.length ; i++) {
			temp.add(s[i]);
		}
		
		for(int i=x ; i<list.size() ; i++) {
			temp.add(list.get(i));
		}
		
		list = temp;
	}
}
