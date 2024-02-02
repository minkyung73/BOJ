package swea.etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_4012 {
	static int n;
	static int[][] map;
	static int min;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			// init
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			sel = new int[n / 2];
			min = Integer.MAX_VALUE;

			// map input
			StringTokenizer st;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			// 조합
			combination(0, 0);

			// result
			sb.append("#").append(i).append(" ").append(min).append("\n\n");
		}

		// output
		System.out.println(sb);
	}

	public static void combination(int idx, int k) {
		// basis
		if (k == (n / 2)) {
			// update min
			calc();
			
			return;
		}
		
		if (idx == n) {
			return;
		}
		
		// inductive
			sel[k] = idx;
			combination(idx + 1, k + 1);
			combination(idx + 1, k);

	}

	public static void calc() {
		// B list
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(i);

		for (int i = 0; i < n / 2; i++) {
			if (list.contains(sel[i])) {
				list.remove(list.indexOf(sel[i]));
			}
		}

		// 시너지 계산
		int a_sum = 0, b_sum = 0;

		// A
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				a_sum += map[sel[i]][sel[j]];
				a_sum += map[sel[j]][sel[i]];
			}
		}

		// B
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				b_sum += map[list.get(i)][list.get(j)];
				b_sum += map[list.get(j)][list.get(i)];
			}
		}

		//
		min = Math.min(min,  Math.abs(a_sum-b_sum)/2);
	}
}
