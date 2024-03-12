package programmers.Lv3;

public class pgrms_단어변환 {
	class Solution {
	    String gBegin, gTarget;
	    String[] gWords;
	    
	    int minCnt;
	    boolean[] visited;
	    
	    public int solution(String begin, String target, String[] words) {
	        int answer = 0;
	        
	        // initialize
	        gBegin = begin;
	        gTarget = target;
	        gWords = words;
	        minCnt = Integer.MAX_VALUE;
	        visited = new boolean[words.length];
	        
	        DFS(gBegin, 0);
	        
	        return minCnt == Integer.MAX_VALUE ? 0 : minCnt;
	    }
	    
	    public void DFS(String word, int cnt) {
	        if(word.equals(gTarget)) {
	            minCnt = Math.min(minCnt, cnt);
	            return ;
	        }
	        
	        for(int i=0 ; i<gWords.length ; i++) {
	            if(!visited[i] && check(word, gWords[i])) {
	                visited[i] = true;
	                DFS(gWords[i], cnt+1);
	                visited[i] = false;
	            }
	        }
	    }
	    
	    public boolean check(String word, String next) {
	        int cnt = 0;
	        
	        for(int i=0 ; i<word.length() ; i++) {
	            if(word.charAt(i) != next.charAt(i)) cnt++;
	        }
	        
	        if(cnt == 1) return true;
	        else return false;
	    }
	}
}
