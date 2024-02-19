package swea.Pro.No5;

// 잘 돌아가는 코드 (약 2초)
class UserSolution2
{
    static int cursor_len;
    static String notepad;
    static int h, w;
    static int[] mask;

    void init(int H, int W, char mStr[])
    {
        h = H;
        w = W;
        cursor_len = 0;
        mask = new int[90000];

        notepad = "";
        for (char c : mStr) {
            if(c == '\0') break;
            notepad += c;
        }
    }

    void insert(char mChar)
    {
        // 문자 삽입
        notepad = notepad.substring(0, cursor_len)
                + mChar + notepad.substring(cursor_len);

        // 커서 위치 변경
        cursor_len++;
    }

    char moveCursor(int mRow, int mCol)
    {
        cursor_len = w * (mRow-1) + (mCol-1);

        if(cursor_len >= notepad.length()) {
            cursor_len = notepad.length();
            return '$';
        }
        return notepad.charAt(cursor_len);
    }

    int countCharacter(char mChar)
    {
        int cnt = 0;

        for(int i=cursor_len ; i<notepad.length() ; i++) {
            if(notepad.charAt(i) == mChar) cnt++;
        }
        
        return cnt;
    }
}