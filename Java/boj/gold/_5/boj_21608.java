package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_21608 {
	// 상어 초등학교
	static int n;
	static Student[] studentList;
	static int[][] map;
	static Seat bestSeat;
	
	public static void main(String[] args) throws IOException {
		init();
		shark();
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		studentList = new Student[n*n];
		map = new int[n+1][n+1];
		
		for(int i=0 ; i<n*n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			studentList[i] = new Student(Integer.parseInt(st.nextToken()), 
										new ArrayList<>());
			studentList[i].bf.add(Integer.parseInt(st.nextToken()));
			studentList[i].bf.add(Integer.parseInt(st.nextToken()));
			studentList[i].bf.add(Integer.parseInt(st.nextToken()));
			studentList[i].bf.add(Integer.parseInt(st.nextToken()));
		}
	}
	
	public static void shark() {
		bestSeat = new Seat(0, 0, 0, 0);

		for(int i=0 ; i<n*n ; i++) {
			Student st = studentList[i];
			
			for(int j=0 ;j<n ;j++) {
				for(int k=0 ; k<n ; k++) {
					if(map[j][k] == 0) {
						Seat tempSeat = fill(st, j, k);
						updateBestSeat(tempSeat);
					}
				}
			}
		}
	}
	
	public static Seat fill(Student st, int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int bfNum = 0;
		int emptyNum = 0;
		
		for(int k=0 ; k<4 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(checkRange(nx, ny)) {
				if(map[nx][ny] == 0) emptyNum++;
				else if(st.bf.contains(map[nx][ny])) bfNum++;
			}
		}
		
		return new Seat(x, y, bfNum, emptyNum);
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 1 && x <= n && y >= 1 && y <= n;
	}
	
	public static void updateBestSeat(Seat tempSeat) {
		
	}
	
	public static class Student {
		int num;
		List<Integer> bf;
		
		public Student(int num, List<Integer> bf) {
			this.num = num;
			this.bf = bf;
		}
	}
	
	public static class Seat {
		int x, y, bfNum, emptyNum;

		public Seat(int x, int y, int bfNum, int emptyNum) {
			super();
			this.x = x;
			this.y = y;
			this.bfNum = bfNum;
			this.emptyNum = emptyNum;
		}
	}
}
