package programmers.kakao;
import java.util.*;

public class pgrms_파괴되지않은건물 {
	class Solution {
	    int n, m, k;
	    int[][] arr;
	    
	    public int solution(int[][] board, int[][] skill) {
	        int answer = 0;
	        
	        // initialize
	        n = board.length;
	        m = board[0].length;
	        k = skill.length;
	        arr = new int[n+1][m+1];
	        
	        // calculate arr -> O(k)
	        for(int i=0 ; i<k ; i++){
	            calculate(skill[i]);
	        }
	        
	        // 위에서 아래로 누적합
	        for(int i=1 ; i<n ; i++) {
	            for(int j=0 ;j<m ;j++) {
	                arr[i][j] += arr[i-1][j];
	            }
	        }
	        
	        // 왼쪽에서 오른쪽으로 누적합
	        for(int i=0 ; i<n ; i++) {
	            for(int j=0 ;j<m ; j++) {
	                if(j!=0) arr[i][j] += arr[i][j-1];
	                if(arr[i][j] + board[i][j] > 0) answer++;
	            }
	        }
	        
	        return answer;
	    }
	    
	    public void calculate(int[] skill) {
	        int x1 = skill[1];
	        int y1 = skill[2];
	        int x2 = skill[3];
	        int y2 = skill[4];
	        int power = skill[0] == 1 ? -skill[5] : skill[5];
	        
	        arr[x1][y1] += power;
	        arr[x1][y2+1] += -power;
	        arr[x2+1][y1] += -power;
	        arr[x2+1][y2+1] += power;
	    }
	}

}
