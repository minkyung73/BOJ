package programmers.kakao;

public class pgrms_양과늑대 {
	
	public static void main(String[] args) {
		
	}
	
	class Solution {
	    Node[] edgeList;
	    int maxSheepNum = 0;
	    
	    public int solution(int[] info, int[][] edges) {
	        edgeList = new Node[info.length];
	        
	        // function call
	        makeBinaryTree(info, edges);
	        
	        for(Node node: edgeList) {
	            System.out.println(node);
	        }
	        
	        // DFS(edgeList[0], 1, 0);
	        
	        return maxSheepNum;
	    }
	    
	    public void makeBinaryTree(int[] info, int[][] edges) {
	        for(int i=0 ; i<info.length ; i++) {
	            edgeList[i] = new Node(info[i]);
	        }
	        
	        for(int i=0 ; i<edges.length ; i++) {
	            int parents = edges[i][0];
	            int child = edges[i][1];
	            
	            if(edgeList[parents].left == -1) edgeList[parents].left = child;
	            else edgeList[parents].right = child;
	        }
	    }
	    
	    public void DFS(int node, int sheepNum, int wolfNum) {
	        // basis part
	        // 늑대가 양보다 많거나 같아서 잡아먹히는 경우
	        if(sheepNum <= wolfNum) return ;
	        
	        // 리프노드인 경우
	        if(edgeList[node].left == -1 && edgeList[node].right == -1) {
	            maxSheepNum = Math.max(maxSheepNum, sheepNum);
	            return ;
	        }
	        
	        // inductive part
	        // move left
	        if(edgeList[node].left != -1) {
	            if(edgeList[edgeList[node].left].animal == 0) DFS(edgeList[node].left, sheepNum+1, wolfNum);
	            else DFS(edgeList[node].left, sheepNum, wolfNum+1);
	        }
	        
	        // move right
	        if(edgeList[node].right != -1) {
	            if(edgeList[edgeList[node].right].animal == 0) DFS(edgeList[node].right, sheepNum+1, wolfNum);
	            else DFS(edgeList[node].right, sheepNum, wolfNum+1);
	        }
	    }
	    
	    public class Node {
	        int animal; // 0:양, 1:늑대
	        int left, right;
	        
	        public Node (int animal) {
	            this.animal = animal;
	            this.left = -1;
	            this.right = -1;
	        }
	        
	        @Override
	        public String toString() {
	            return "[animal: " + animal + ", left:" + left + " , right:" + right + "]\n";
	        }
	    }
	}

}
