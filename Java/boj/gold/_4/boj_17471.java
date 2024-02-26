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
	static int[] population;
	static int[][] map;
	static List<Integer> teamA, teamB;
	static int result;
	static int cnt;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		init();
		powerSet(1, 1, new boolean[N+1]);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		map = new int[N+1][N+1];
		result = Integer.MAX_VALUE;
		
		// 각 구역의 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N ; i++) 
			population[i] = Integer.parseInt(st.nextToken());
		
		// 인접한 구역 연결하기
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for(int j=0 ; j<num ; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][v] = map[v][i] = 1;
			}
		}
	}

	public static void powerSet(int idx, int k, boolean[] sel) {
		// basis part
		if(idx == N+1) {
			int res = divideTeam(sel);
			result = Math.min(result, res);
			return ;
		}
		
		// inductive part
		sel[idx] = true;
		powerSet(idx+1, k+1, sel);
		sel[idx] = false;
		if(idx != 1) powerSet(idx+1, k, sel);
	}

	public static int divideTeam(boolean[] sel) {
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();

		// 1번 구역은 무조건 teamA
		for (int i = 1; i <= N; i++) {
			if(sel[i] == sel[1]) teamA.add(i);
			else teamB.add(i);
		}

		// 인접한지 확인
		if (!teamA.isEmpty() && !teamB.isEmpty()) {
			int popsA = 0, popsB = 0;

			// A
			cnt = 0;
			flag = false;
			DFS(teamA.get(0), teamA, new boolean[N+1]);
			if(flag) popsA = getPops(teamA);

			// B
			cnt = 0;
			flag = false;
			DFS(teamB.get(0), teamB, new boolean[N+1]);
			if(flag) popsB = getPops(teamB);

			if(popsA != 0 && popsB != 0)
				return Math.abs(popsA - popsB);
		}

		return Integer.MAX_VALUE;
	}

	public static void DFS(int node, List<Integer> team, boolean[] visited) {
		visited[node] = true;
		cnt++;

		if (cnt == team.size()) {
			flag = true;
			return ;
		}

		for(int i=1 ; i<=N ; i++) {
			if (!visited[i] && map[node][i] == 1 && team.contains(i)) {
				DFS(i, team, visited);
			}
		}
	}

	public static int getPops(List<Integer> team) {
		int sum = 0;

		for (Integer idx : team) {
			sum += population[idx];
		}

		return sum;
	}
}
