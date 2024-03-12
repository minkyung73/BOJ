package programmers.Lv3;
import java.util.*;

public class pgrms_최고의집합 {
	class Solution {
	    public int[] solution(int n, int s) {
	        int[] answer = new int[n];
	        
	        if(n > s) return new int[]{-1};
	        
	        int num = s / n;
	        for(int i=0 ; i<n ; i++) answer[i] = num;
	        if(s % n != 0) {
	            for(int i = n-1 ; i> n-1 - (s % n) ; i--) {
	                answer[i]++;
	            }
	        }
	        
	        return answer;
	    }
	}
}
