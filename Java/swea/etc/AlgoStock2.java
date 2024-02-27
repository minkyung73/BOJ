package swea.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlgoStock2 {
	// 알고스탁
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int Ms, Ma;
	static int N, L;
	static int[][] data;
	static int original;	// 투자 원금
	static int money;
	static int[] weights;
	static int maxProfit;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=T ; i++) {
			init();
			stock();
			sb.append("#").append(i).append(" ");
			sb.append(money-original).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Ms = Integer.parseInt(st.nextToken());
		Ma = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
	
		data = new int[N][L+1];
		original = Ms + Ma * L;	// 총 투자 원금
		money = Ms;
		
		for(int i=0 ;i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<L+1 ; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void stock() {
		// 0개월 ~ 7개월
		for(int i=0 ; i<L ; i++) {
			if(i!=0) money += Ma;	// 추가 불입금액
			
			updateWeight(i);
			maxProfit = 0;
			powerSet(i, 0, money, money, 0, 0);
			
			money += maxProfit;	// 최대 주식 차익
			
//			System.out.println(i + "개월 잔고: " + money);
		}
		money += Ma;
	}
	
	public static void updateWeight(int month) {
		weights = new int[N];
		for(int i=0 ; i<N ; i++)
			weights[i] = data[i][month+1] - data[i][month];
	}
	
	/**
	 * @param month			개월
	 * @param idx 			종목
	 * @param prevMoney		이전에 남았던 금액
	 * @param curMoney		현재 남은 금액
	 * @param prevProfit	이전에 얻었던 수익
	 * @param curProfit		현재 얻은 수익
	 */
	public static void powerSet(int month, int idx, int prevMoney, int curMoney, int prevProfit, int curProfit) {
		// basis part
		if(idx == N) return ;
		
		// 수익을 내지 못하는 종목인 경우
		if(weights[idx] <= 0) {
			powerSet(month, idx+1, prevMoney, curMoney, prevProfit, curProfit);
			return ;
		}
		
		// 더 이상 살 수 없는 경우 (현재 돈이 부족한 경우)
		if(prevMoney < data[idx][month]) {
			maxProfit = Math.max(maxProfit, prevProfit);
			return ;
		}
		
		// inductive part
		powerSet(month, idx, curMoney, curMoney - data[idx][month], curProfit, curProfit + weights[idx]);
		powerSet(month, idx+1, prevMoney, curMoney, prevProfit, curProfit);
	}
}
