package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17471 {
	// 게리맨더링
	static int N;
	static District[] districts;
	static int[] pops, parents;
	static int result;
	
	public static void main(String[] args) throws IOException {
		init();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pops = new int[N+1];
		parents = new int[N+1];
		districts = new District[N+1];
		result = Integer.MAX_VALUE;

		// 각 구역의 인구 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N ; i++) pops[i] = Integer.parseInt(st.nextToken());
		
		// 부모 노드
		for(int i=1 ; i<=N ; i++) parents[i] = i;
		
		// 인접한 구역
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int[] temp = new int[num];
			for(int j=0 ;j<num ; j++) temp[j] = Integer.parseInt(st.nextToken());
			
			districts[i] = new District(pops[i], temp);
		}
	}

	public static void powerSet(int idx, int k, boolean[] sel) {
		// basis part
		if(idx == N) {
			int res = getRes(sel);	// 각 인구의 차이 구하기
			if(res != -1) result = Math.min(result, res);	
			return ;
		}
		
		// inductive part
		sel[idx] = true;
		powerSet(idx+1, k+1, sel);
		sel[idx] = false;
		if(idx != 0) powerSet(idx+1, k, sel);
	}
	
	public static int getRes(boolean[] sel) {
		// 팀 나누기
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for(int i=0 ; i<sel.length ; i++) {
			if(sel[i]) teamA.add(i+1);
			else teamB.add(i+1);
		}
		
		// 팀끼리 인접해있지 않다면 return -1
		int popA = adj(teamA);
		int popB = adj(teamB);
		if(popA == -1 || popB == -1) return -1;
		
		return Math.abs(popA - popB);
	}
	
	public static int adj(List<Integer> team) {
		int sum = 0;
		
		if(team.isEmpty()) return -1;
		
		for(int i=0 ; i<team.size() ; i++) {
			
		}
		
		return sum;
	}
	
	public static class District {
		int population;
		int[] neighbor;
		
		public District(int population, int[] neighbor) {
			this.population = population;
			this.neighbor = neighbor;
		}
	}
}
