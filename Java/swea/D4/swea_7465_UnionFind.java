package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_7465_UnionFind {
	// 창용 마을 무리의 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int representative[];
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			int res = solution();
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		representative = new int[n+1];
		
		for(int i=1 ; i<=n ; i++) representative[i] = i;
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) != find(b)) union(a, b);
		}
	}
	
	public static void union(int repNum, int changedNum) {
		int n1 = find(repNum);
		int n2 = find(changedNum);
		
		if(n1 != n2) {
			representative[n2] = n1;
		}
	}
	
	public static int find(int num) {
		if(representative[num] == num) return num;
		return representative[num] = find(representative[num]);
	}

	public static int solution() {
		int cnt = 0;
		int[] res = new int[n+1];
		
		for(int i=1 ; i<=n ; i++) {
			res[find(i)]++;
		}
		
		for(int i=1 ; i<=n ; i++) {
			if(res[i] > 0) cnt++;
		}
		
		return cnt;
	}
}
