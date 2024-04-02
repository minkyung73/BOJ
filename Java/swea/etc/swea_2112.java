package swea.etc;

import java.io.*;
import java.util.*;

public class swea_2112 {
	// [모의 SW 역량테스트] 보호 필름
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int D, W, K;
	static int[][] map;
	static int minCnt;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			DFS(0, 0);
			sb.append("#").append(i).append(" ").append(minCnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		map = new int[D][W];
		minCnt = Integer.MAX_VALUE;
		
		for(int i=0 ; i<D ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<W ; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void DFS(int idx, int cnt) {
		if(cnt >= minCnt) return ;
		
		if(idx == D) {			
			L: for (int i = 0; i < W; i++) {
                int same = 1;
                for (int j = 0; j < D - 1; j++) {
                    if (map[j][i] == map[j + 1][i]) same++;
                    else same = 1;
                    
                    if (same >= K) continue L;
                }
                return;
            }
            minCnt = Math.min(minCnt, cnt);
            return;
		}
		
		// 안 바꿨을 때
		int[] temp = map[idx].clone();
		DFS(idx+1, cnt);

		// 0으로 채웠을 때
		Arrays.fill(map[idx], 0);
		DFS(idx+1, cnt+1);
		
		// 1로 채웠을 때
		Arrays.fill(map[idx], 1);
		DFS(idx+1, cnt+1);
		
		// 원상복구
		map[idx] = temp;
	}
}
