package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_21939 {
	// 문제 추천 시스템 Version 1
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static TreeSet<Problem> problemTree;
	static HashMap<Integer, Integer> problemMap;
	
	public static void main(String[] args) throws IOException {
		init();
		command();
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		problemTree = new TreeSet<>();
		problemMap = new HashMap<>();
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int difficulty = Integer.parseInt(st.nextToken());
			problemTree.add(new Problem(num, difficulty));
			problemMap.put(num, difficulty);
		}
	}
	
	public static void command() throws IOException {
		M = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			if(str.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				recommend(x);
			} 
			else if(str.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				add(p, l);
			}
			else if(str.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				solved(p);
			}
		}
	}
	
	public static void recommend(int x) {
		if(x==1) sb.append(problemTree.last().num).append("\n");
		else sb.append(problemTree.first().num).append("\n");
	}
	
	public static void add(int p, int l) {
		problemTree.add(new Problem(p, l));
		problemMap.put(p, l);
	}
	
	public static void solved(int p) {
		int l = problemMap.get(p);
		problemMap.remove(p);
		problemTree.remove(new Problem(p, l));
	}

	public static class Problem implements Comparable<Problem>{
		int num, difficulty;

		public Problem(int num, int difficulty) {
			this.num = num;
			this.difficulty = difficulty;
		}

		@Override
		public String toString() {
			return "Problem [num=" + num + ", difficulty=" + difficulty + "]";
		}

		@Override
		public int compareTo(Problem o) {
			return this.difficulty != o.difficulty ? 
					Integer.compare(this.difficulty, o.difficulty) :
						Integer.compare(this.num, o.num);
		}
	}
}
