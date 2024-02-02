package swea.D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_6808 {
	static int[] kyu, in;
	static List<Integer> cards;
	static int win, lose;
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1 ; i<=T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			cards = new ArrayList<>();
			for(int j=1 ; j<=18 ;j++) cards.add(j);
			
			kyu = new int[9];
			in = new int[9];
			visited = new boolean[9];
			sel = new int[9];
			win = lose = 0;
			
			// 규영
			for(int j=0 ; j<9 ; j++) {
				kyu[j] = Integer.parseInt(st.nextToken());
				cards.remove(cards.indexOf(kyu[j]));
			}
			
			// 인영이가 가질 수 있는 카드
			for(int j=0 ;j<9 ;j++)
				in[j] = cards.get(j);
			
			
			// 순열
			permutation(0, 0);
			
			
			// result
			sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		// output
		System.out.println(sb);
	}
	
	// 
	public static void round() {
		int k_sum = 0;
		int i_sum = 0;
		
		for(int i=0 ; i<9 ; i++) {
			if(kyu[i] > sel[i]) k_sum += kyu[i] + sel[i];
			else if(kyu[i] < sel[i]) i_sum += kyu[i] + sel[i];
		}
		
		if(k_sum > i_sum) win++;
		else if(k_sum < i_sum) lose++;
	}
	
	// k가 뽑은 개수
	// idx가 현재 위치
	public static void permutation(int idx, int k) {
		// basis part
		if(idx == 9) {
			round();
			return ;
		}
		
		// inductive part
		for(int i=0 ; i<9 ; i++) {
			if(!visited[i]) {
				visited[i] = true; 
				sel[k] = in[i];
				permutation(idx+1, k+1);
				visited[i] = false;
			}
		}
	}

}
