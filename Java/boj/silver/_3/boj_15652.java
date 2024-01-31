package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15652 {
	// N과 M (4) - 중복 순열
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];

		// function call
		recursive(0, 1);

		// output
		System.out.println(sb);
	}

	private static void recursive(int k, int idx) {
		// basis part
		if (k == m) {
			for (int i : selected)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		// inductive part
		for (int i = idx; i <= n; i++) {
			selected[k] = i;
			recursive(k + 1, i);
		}
	}

}
