package boj.silver._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1931 {
    // 회의실 배정
    private static int n;
    private static Meeting[] meetings;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(count());
    }
    
    public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        meetings = new Meeting[n];

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
    }
    
    public static int count() {
    	int cnt = 1;
    	int end = meetings[0].end;
    	
    	for(int i=1 ; i<n ; i++) {
    		if(end <= meetings[i].start) {
    			end = meetings[i].end;
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
    
    public static class Meeting implements Comparable<Meeting>{
    	int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
    }
}
