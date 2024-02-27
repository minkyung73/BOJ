package boj.gold._3;

import java.io.*;
import java.util.*;

public class boj_2457_2 {

	static int N;
	static List<Date> flowers;
	static Date prevDate, curDate;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(anniversary());
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		flowers = new ArrayList<>();
		prevDate = new Date(3, 1, 3, 1);
		curDate = null;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());

			// 종료 날짜가 3/1 이후, 시작 날짜가 11/30 이전은 넣지말자
			if (em < 3 || sm > 11) continue;

			flowers.add(new Date(sm, sd, em, ed));
		}
		Collections.sort(flowers);

		// 만약 현재 종료 날짜가 이전 날짜보다 빠르다면 제거한다.
		for (int i = N - 1; i >= 1; i--) {
			Date cur = flowers.get(i);
			Date prev = flowers.get(i - 1);

			if (cur.endMonth > prev.endMonth 
					|| (cur.endMonth == prev.endMonth && cur.endDay > prev.endDay))
				continue;

			flowers.remove(i);
		}

		for (Date date : flowers) System.out.println(date);
		System.out.println("==============================");
	}

	public static int anniversary() {
		int cnt = 0;

		for (int i = 0; i < flowers.size(); i++) {
			Date date = flowers.get(i);

			if (compareDate(prevDate, date)) curDate = date;
			else {
				prevDate = curDate;
				cnt++;
				System.out.println(cnt + " " + prevDate);

				if (compareDate(prevDate, date)) curDate = date;
				else return 0;
			}
		}

		// 마지막
		if (compareDate(curDate, new Date(11, 30, 11, 30))) cnt++;
		else return 0;

		return cnt;
	}

	public static boolean compareDate(Date d1, Date d2) {
		// d2의 시작 날짜가 d1의 종료 날짜 이전에 있는지
		if (d2.startMonth < d1.endMonth) return true;
		else if (d2.startMonth > d1.endMonth) return false;
		else {
			if (d2.startDay <= d1.endDay) return true;
			else return false;
		}
	}

	public static class Date implements Comparable<Date> {
		int startMonth, startDay;
		int endMonth, endDay;

		public Date(int startMonth, int startDay, int endMonth, int endDay) {
			this.startMonth = startMonth;
			this.startDay = startDay;
			this.endMonth = endMonth;
			this.endDay = endDay;
		}

		@Override
		public int compareTo(Date o) {
			if (this.startMonth != o.startMonth)
				return this.startMonth - o.startMonth;
			else if (this.startDay != o.startDay)
				return this.startDay - o.startDay;
			else if (this.endMonth != o.endMonth)
				return this.endMonth - o.endMonth;
			else
				return this.endDay - o.endDay;
		}

		@Override
		public String toString() {
			return "Date [startMonth=" + startMonth + ", startDay=" + startDay + ", endMonth=" + endMonth + ", endDay="
					+ endDay + "]";
		}
	}
}
