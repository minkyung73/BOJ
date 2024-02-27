package boj.gold._3;
import java.io.*;
import java.util.*;

public class boj_2457 {
	
	static int N;
	static PriorityQueue<Date> projects;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(participate());
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		projects = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
		
			projects.add(new Date(sm, sd, em, ed));
		}
	}
	
	public static int participate() {
		int curEndMonth = -1;
		int curEndDay = -1;
		int cnt = 0;
		
		while(!projects.isEmpty()) {
			Date date = projects.poll();
			
			// 시작일이 3/1 보다 늦거나 
			// 종료일이 3월 이전인 경우
			if((date.startMonth ==3 && date.startDay > 1) 
					|| date.endMonth < 3) continue;
			
			curEndMonth = date.endMonth;
			curEndDay = date.endDay;
			cnt++;
			break;
		}
		if(curEndMonth == -1) return 0;
		
		//
		while(!projects.isEmpty()) {
			Date date = projects.poll();
			
			// 현재 date의 마감일자가 11/30 보다 크면 return cnt
//			if(date.endMonth > 11) return ++cnt;
			
			// 바로 다음 프로젝트 참여가 가능한지
			// 기간 내에 있는지 check
			if(checkDate(curEndMonth, curEndDay, date)) {
				curEndMonth = date.endMonth;
				curEndDay = date.endDay;
				cnt++;
			} else return 0;
		}
		
		return cnt;
	}
	
	public static boolean checkDate(int curEndMonth, int curEndDay, Date date) {
		if(curEndMonth > 11 || (curEndMonth == 11 && curEndDay == 30))
			return false;
		
		if(curEndMonth == date.startMonth) {
			if(curEndDay == date.startDay) {
				return true;
			} else {
				if(date.startDay > curEndDay) return false;
				else return true;
			}
		} else {
			if(date.startMonth > curEndMonth) return false;
			else return true;
		}
	}

	public static class Date implements Comparable<Date>{
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
			if(this.startMonth != o.startMonth)
				return this.startMonth - o.startMonth;
			else if (this.startDay != o.startDay)
				return this.startDay - o.startDay;
			else if(this.endMonth != o.endMonth)
				return o.endMonth - this.endMonth;
			else
				return o.endDay - this.endDay;
		}

		@Override
		public String toString() {
			return "Date [startMonth=" + startMonth + ", startDay=" + startDay + ", endMonth=" + endMonth + ", endDay="
					+ endDay + "]";
		}
	}
}
