package hdst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class hdst_6288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Bag[] arr = new Bag[n];

		// input
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			arr[i] = new Bag(m, p);
		}

		// 높은 가격 순으로 정렬
		Arrays.sort(arr, new Comparator<Bag>() {
			@Override
			public int compare(Bag o1, Bag o2) {
				return o2.price - o1.price;
			}
		});

		// calculate
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].num <= w) {
				res += arr[i].price * arr[i].num;
				w -= arr[i].num;
			} else if (arr[i].num > w) {
				res += arr[i].price * w;
				w = 0;
			} 
		}
		
		// output
		System.out.println(res);
	}

	public static class Bag {
		int num;
		int price;

		public Bag(int num, int price) {
			super();
			this.num = num;
			this.price = price;
		}
	}
}
