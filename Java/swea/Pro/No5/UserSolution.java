package swea.Pro.No5;

import java.util.Arrays;
import java.util.LinkedList;

class UserSolution
{
    static int cursor_len;
    int H, W;
    LinkedList<Node> list = new LinkedList<>();
    

    void init(int H, int W, char mStr[])
    {
    	this.H = H;
    	this.W = W;
    	cursor_len = 0;
    	
        for(int i=0 ; i<mStr.length ; i++) {
        	if(mStr[i] == '\0') break;
        	if(i == 0) {
        		list.add(new Node(mStr[i], new int[26]));
        		list.get(i).abc[mStr[i]-'a']++;
        	}
        	else {
        		list.add(new Node(mStr[i], list.get(i-1).abc));
        		list.get(i).abc[mStr[i]-'a']++;
        	}
        }
        
        System.out.println("=======[INIT]=======");
        for (Node node : list) {
			System.out.println(node);
		}
    }

    void insert(char mChar)
    {
        // 문자 삽입
    	int idx = cursor_len == 0 ? cursor_len : cursor_len+1;
    	int[] temp_abc = list.get(idx).abc;
    	idx++;
    	temp_abc[mChar-'a']++;
    	
    	Node node = new Node(mChar, temp_abc);
        list.add(idx, node);

    }

    char moveCursor(int mRow, int mCol)
    {
        cursor_len = W * (mRow-1) + (mCol-1);

        if(cursor_len >= list.size()) {
            cursor_len = list.size();
            return '$';
        }
        
        return list.get(cursor_len).mChar;
    }

    int countCharacter(char mChar)
    {
    	if(!list.contains(mChar)) return 0;

        return list.get(list.size()-1).abc[mChar-'a'];
    }
    
    class Node {
    	char mChar;
    	int[] abc;
		
    	public Node(char mChar, int[] abc) {
			this.mChar = mChar;
			this.abc = abc;
		}

		@Override
		public String toString() {
			return "Node [mChar=" + mChar + ", abc=" + Arrays.toString(abc) + "]";
		}
    	
    	
    }
}