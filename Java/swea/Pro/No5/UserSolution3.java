package swea.Pro.No5;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

class UserSolution3
{
	static Point cursor;
	static int h, w;
	static char[][] map;
	static LinkedList<int[]> abc;

    void init(int H, int W, char mStr[])
    {
        cursor = new Point(0, 0);
        h = H;
        w = W;
        map = new char[h][w];
        abc = new LinkedList<>();
        
        int idx = 0;
        L: for(int i=0 ; i<h ; i++) {
        	abc.add(new int[26]);
        	
        	for(int j=0 ; j<w ; j++) {
        		if(mStr[idx] == '\0') break L;
        		
        		map[i][j] = mStr[idx++];		
        		abc.get(i)[map[i][j]-'a']++;
        	}
        }
        
//        print();
    }
    
    void print() {
    	for(int i=0 ; i<h ; i++) {
    		for(int j=0 ; j<w ; j++) {
    			System.out.print(map[i][j]);
    		}
    		System.out.println();
    	}
    }

    void insert(char mChar)
    {
    	
    }

    char moveCursor(int mRow, int mCol)
    {
        return '$';
    }

    int countCharacter(char mChar)
    {
        
        return 0;
    }
}